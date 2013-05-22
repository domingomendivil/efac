package xg.generadorcfes;

import uy.gub.dgi.cfe.CAEDataType;
import uy.gub.dgi.cfe.CAEdefType;
import uy.gub.dgi.cfe.CFEDefType;
import uy.gub.dgi.cfe.CFEDefType.EFact;
import uy.gub.dgi.cfe.CFEDefType.ERem;
import uy.gub.dgi.cfe.CFEDefType.ERem.Encabezado;
import uy.gub.dgi.cfe.CFEDefType.EResg;
import uy.gub.dgi.cfe.CFEDefType.ETck;
import uy.gub.dgi.cfe.CFEDefTypeX;
import uy.gub.dgi.cfe.CFEDefTypeX.EFactX;
import uy.gub.dgi.cfe.CFEDefTypeX.ERemX;
import uy.gub.dgi.cfe.CFEDefTypeX.ERemX.Encabezado.Totales;
import uy.gub.dgi.cfe.CFEDefTypeX.EResgX;
import uy.gub.dgi.cfe.CFEDefTypeX.ETck.Encabezado.IdDoc;
import uy.gub.dgi.cfe.IdDocTck;
import uy.gub.dgi.cfe.ItemDetFact;
import uy.gub.dgi.cfe.Referencia;
import uy.gub.dgi.cfe.Referencia.ReferenciaElement;
import uy.gub.dgi.cfe.ReferenciaEl;
import xg.beans.CFEBean;
import xg.xml.XMLMarshaller;
import xg.xml.XMLMarshallerImpl;
import xg.xml.XMLSigner;

public class GeneradorCFEsImpl implements GeneradorCFEs{

	private XMLSigner xmlSigner;
	private XMLMarshaller xmlMarshaller;

	public GeneradorCFEsImpl(XMLSigner xmlSigner) {
		this.xmlSigner = xmlSigner;
		xmlMarshaller = new XMLMarshallerImpl();
	}

	private CFEDefType clone(CFEDefTypeX cfe_x) {
		CFEDefType cfe = new CFEDefType();
		switch (cfe_x.getTipoCFE()) {
		case 1:
			cfe.setEFact(clone(cfe_x.getEFactX()));
		case 2:
			cfe.setERem(clone(cfe_x.getERemX()));
		case 3:
			cfe.setEResg(clone(cfe_x.getEResgX()));
		case 4:
			cfe.setETck(clone(cfe_x.getETck()));
		}
		return cfe;
	}
	
	private void cloneIdDoc(IdDoc idDoc,IdDocTck res){
		res.setFchEmis(idDoc.getFchEmis());
		res.setFchVenc(idDoc.getFchVenc());
		res.setFmaPago(idDoc.getFmaPago());
		res.setMntBruto(idDoc.getMntBruto());
		res.setNro(idDoc.getNro());
		res.setPeriodoDesde(idDoc.getPeriodoDesde());
		res.setPeriodoHasta(idDoc.getPeridoHasta());
		res.setSerie(idDoc.getSerie());
		res.setTipoCFE(idDoc.getTipoCFE());
	}
	
	private Referencia getReferencia(ReferenciaEl refEl){
		Referencia res = new Referencia();
		for (ReferenciaEl.Referencia ref:refEl.getReferencia() ){
			ReferenciaElement el = new ReferenciaElement();
			el.setFechaCFEref(ref.getFechaCFEref());
			el.setIndGlobal(ref.getIndGlobal());
			el.setNroCFERef(ref.getNroCFERef());
			el.setNroLinRef(ref.getNroLinRef());
			el.setRazonRef(ref.getRazonRef());
			el.setSerie(ref.getSerie());
			el.setTpoDocRef(ref.getTpoDocRef());
			res.getReferencia().add(el);
		}
		return res;
	}

	private ETck clone(uy.gub.dgi.cfe.CFEDefTypeX.ETck eTck_x) {
		ETck etck = new ETck();
		for (ItemDetFact item: eTck_x.getDetalle().getItem()){
			etck.getDetalle().getItem().add(item);
		}
		etck.setDscRcgGlobal(eTck_x.getDscRcgGlobal());
		etck.getEncabezado().setEmisor(eTck_x.getEncabezado().getEmisor());
		cloneIdDoc(eTck_x.getEncabezado().getIdDoc(),etck.getEncabezado().getIdDoc());
		etck.getEncabezado().setReceptor(eTck_x.getEncabezado().getReceptor());
		etck.getEncabezado().setTotales(eTck_x.getEncabezado().getTotales());
		etck.setMediosPago(eTck_x.getMediosPago());
		etck.setReferencia(getReferencia(eTck_x.getReferencia()));
		etck.setSubTotInfo(eTck_x.getSubTotInfo());
		return etck;
	}

	private EResg clone(EResgX eResgX) {
		EResg eresg = new EResg();
		eresg.getEncabezado().setEmisor(eResgX.getEncabezado().getEmisor());
		eresg.getEncabezado().setIdDoc(eResgX.getEncabezado().getIdDoc());
		eresg.getEncabezado().setReceptor(eResgX.getEncabezado().getReceptor());
		eresg.getEncabezado().setTotales(eResgX.getEncabezado().getTotales());
		eresg.setReferencia(getReferencia(eResgX.getReferenciaEl()));
		eresg.setSubTotInfo(eResgX.getSubTotInfo());
		return eresg;
	}


	private ERem clone(ERemX eRemX) {
		ERem erem = new ERem();
		erem.getEncabezado().setEmisor(eRemX.getEncabezado().getEmisor());
		eRemX.getEncabezado().setIdDoc(eRemX.getEncabezado().getIdDoc());
		erem.getEncabezado().setReceptor(eRemX.getEncabezado().getReceptor());
		cloneTotales(eRemX.getEncabezado().getTotales(),erem.getEncabezado());
		erem.setReferencia(getReferencia(eRemX.getReferenciaEl()));
		erem.setSubTotInfo(eRemX.getSubTotInfo());
		return erem;
	}


	private void cloneTotales(Totales totales, Encabezado encabezado) {
		uy.gub.dgi.cfe.CFEDefType.ERem.Encabezado.Totales valor = new uy.gub.dgi.cfe.CFEDefType.ERem.Encabezado.Totales();
		valor.setCantLinDet(totales.getCantLinDet());
		encabezado.setTotales(valor);
	}

	private EFact clone(EFactX eFactX) {
		EFact efact = new EFact();
		efact.setDscRcgGlobal(eFactX.getDscRcgGlobal());
		efact.getEncabezado().setEmisor(eFactX.getEncabezado().getEmisor());
		eFactX.getEncabezado().setIdDoc(eFactX.getEncabezado().getIdDoc());
		efact.getEncabezado().setReceptor(eFactX.getEncabezado().getReceptor());
		efact.getEncabezado().setTotales(eFactX.getEncabezado().getTotales());
		efact.setMediosPago(eFactX.getMediosPago());
		efact.setReferencia(getReferencia(eFactX.getReferenciaEl()));
		efact.setSubTotInfo(eFactX.getSubTotInfo());
		return efact;
	}


	private CAEDataType getCAEDataType(CAEdefType cae) {
		CAEDataType caeData = new CAEDataType();
		caeData.setDNro(cae.getDA().getDNro());
		caeData.setHNro(cae.getDA().getHNro());
		caeData.setFecVenc(cae.getDA().getFVD());
		caeData.setCAEID(cae.getDA().getNA());
		return caeData;
	}

	public CFEBean generarCFE(CFEDefTypeX cfe_x, CAEdefType cae, int nro) throws GeneradorCFEException {
		CFEDefType cfe = clone(cfe_x);
		switch (cfe_x.getTipoCFE()) {
		case CFEBean.ETICKET:;
		case CFEBean.ETICKET_NOTA_CREDITO:
			cfe.getETck().setCAEData(getCAEDataType(cae));
		case CFEBean.ETICKET_NOTA_DEBITO:
			cfe.getETck().setCAEData(getCAEDataType(cae));
		case CFEBean.EFACTURA:
			cfe.getEFact().setCAEData(getCAEDataType(cae));
		case CFEBean.EFACTURA_NOTA_CREDITO:
			cfe.getEFact().setCAEData(getCAEDataType(cae));
		case CFEBean.EFACTURA_NOTA_DEBITO:
			cfe.getERem().setCAEData(getCAEDataType(cae));
		case 7:cfe.getEResg().setCAEData(getCAEDataType(cae));
		}
		try{
			String xmlData = xmlMarshaller.unmarshall(cfe);
			String res = xmlSigner.sign(xmlData);
			CFEDefType newCFE = (CFEDefType) xmlMarshaller.marshall(CFEDefType.class,res);
			CFEBean bean = new CFEBean();
			bean.setCfe(newCFE);
			return bean;
		}catch (Exception e){
			throw new GeneradorCFEException(e);
		}

	}


}
