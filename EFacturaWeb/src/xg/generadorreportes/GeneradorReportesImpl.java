package xg.generadorreportes;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.xml.datatype.XMLGregorianCalendar;

import uy.gub.dgi.cfe.MontosFyT;
import uy.gub.dgi.cfe.MontosFyT.MntsFyTItem;
import uy.gub.dgi.cfe.ReporteDefType;
import uy.gub.dgi.cfe.ReporteDefType.Caratula;
import uy.gub.dgi.cfe.ReporteDefType.RsmnFac;
import uy.gub.dgi.cfe.ReporteDefType.RsmnFacCont;
import uy.gub.dgi.cfe.ReporteDefType.RsmnFacContNotaCredito;
import uy.gub.dgi.cfe.ReporteDefType.RsmnFacContNotaDebito;
import uy.gub.dgi.cfe.ReporteDefType.RsmnFacNotaCredito;
import uy.gub.dgi.cfe.ReporteDefType.RsmnFacNotaDebito;
import uy.gub.dgi.cfe.ReporteDefType.RsmnRem;
import uy.gub.dgi.cfe.ReporteDefType.RsmnRemCont;
import uy.gub.dgi.cfe.ReporteDefType.RsmnResg;
import uy.gub.dgi.cfe.ReporteDefType.RsmnResgCont;
import uy.gub.dgi.cfe.ReporteDefType.RsmnTck;
import uy.gub.dgi.cfe.ReporteDefType.RsmnTckCont;
import uy.gub.dgi.cfe.ReporteDefType.RsmnTckContNotaCredito;
import uy.gub.dgi.cfe.ReporteDefType.RsmnTckNotaCredito;
import uy.gub.dgi.cfe.ReporteDefType.RsmnTckNotaDebito;
import uy.gub.dgi.cfe.RsmnDataFacCont;
import uy.gub.dgi.cfe.RsmnDataTck;
import uy.gub.dgi.cfe.TotalItem;
import uy.gub.dgi.dao.DAO;
import uy.gub.dgi.dao.DAOException;
import xg.beans.CFEBean;
import xg.beans.ReporteBean;
import xg.caebusiness.GeneralConfiguration;
import xg.dao.CFEFilter;
import xg.dao.GenericFilter;
import xg.xml.XMLGregorianCalendarConverter;
import xg.xml.XMLMarshallerImpl;
import xg.xml.XMLSignerImpl;

public class GeneradorReportesImpl {
	

	private XMLSignerImpl xmlSigner;
	private XMLMarshallerImpl xmlMarshaller;
	private DAO dao;
	private GeneralConfiguration config;
	
	public GeneradorReportesImpl(GeneralConfiguration config,DAO dao,XMLSignerImpl xmlSigner,XMLMarshallerImpl xmlMarshaller){
		this.config = config;
		this.xmlMarshaller=xmlMarshaller;
		this.xmlSigner=xmlSigner;
		this.dao=dao;
	}
	public ReporteBean generarReporte() throws GeneradorReportesException{
		//TODO
		return null;
	}
	
	public ReporteBean generarReporte(InGenerarReporte in) throws GeneradorReportesException{
		//TODO
		try{
			ReporteDefType reporte = new ReporteDefType();
			reporte.setCaratula(getCaratula(in));
			reporte.setRsmnFac(getResumenFac(in.getCfes()));
			reporte.setRsmnFacCont(getResumenFacCont(in.getCfes()));
			reporte.setRsmnFacContNotaCredito(getResumenFacContNotaCredito(in.getCfes()));
			reporte.setRsmnFacContNotaDebito(getResumenFacContNotaDebito(in.getCfes()));
			reporte.setRsmnFacNotaCredito(getResumenFacNotaCredito(in.getCfes()));
			reporte.setRsmnFacNotaDebito(getResumenFacNotaDebito(in.getCfes()));
			reporte.setRsmnRem(getResumenRemito(in.getCfes()));
			reporte.setRsmnRemCont(getResumenRemitoCont(in.getCfes()));
			reporte.setRsmnResg(getResumenResguardo(in.getCfes()));
			reporte.setRsmnResgCont(getResumenResguardoCont(in.getCfes()));
			reporte.setRsmnTck(getResumenTicket(in.getCfes()));
			reporte.setRsmnTckCont(getResumenTicketCont(in.getCfes()));
			reporte.setRsmnTckContNotaCredito(getResumenTicketContNotaCredito(in.getCfes()));
			reporte.setRsmnTckNotaCredito(getResumenTicketNotaCredito(in.getCfes()));
			reporte.setRsmnTckNotaDebito(getResumenTicketNotaDebito(in));
			String xmlReporte=xmlMarshaller.unmarshall(reporte);
			String xmlReporteFirmado=xmlSigner.sign(xmlReporte);
			reporte = (ReporteDefType)xmlMarshaller.marshall(ReporteDefType.class, xmlReporteFirmado);
			ReporteBean rep = new ReporteBean();
			rep.setReporte(reporte);
			return rep;
			
		
		}catch (Exception e){
			throw new GeneradorReportesException(e);
		}

	}
	


	private RsmnTckNotaDebito getResumenTicketNotaDebito(InGenerarReporte in) throws DAOException {
		RsmnTckNotaDebito rsmn = new RsmnTckNotaDebito();
		RsmnDataTck data = new RsmnDataTck();
		int tipoCFE =CFEBean.ETICKET_NOTA_DEBITO;
		data.setMontos(getMontos(tipoCFE));
		data.setCantDocsAnulados(getCantDocsAnulados(tipoCFE,in));
		data.setCantDocsEmi(getCantDocEmitidos(tipoCFE,in));
		data.setCantDocsMayTopeUI(getCantDocsMayorTopeEstablecido(tipoCFE,in));
		data.setCantDocsUtil(getCantDocsUtilizados(tipoCFE,in));
		rsmn.setRsmnData(data);
		return rsmn;

	}


	private BigInteger getCantDocEmitidos(int tipoCFE,
			InGenerarReporte in) throws DAOException {
		CFEFilter filter = new CFEFilter();
		int i= dao.getCount(CFEBean.class, filter);
		BigInteger big = new BigInteger(""+i);
		return big;
	}


	private BigInteger getCantDocsUtilizados(int tipoCFE,
			InGenerarReporte in) throws DAOException {
		CFEFilter filter = new CFEFilter();
		int i= dao.getCount(CFEBean.class, filter);
		BigInteger big = new BigInteger(""+i);
		return big;
	}


	private BigInteger getCantDocEmitidos(int tipoCFE) throws DAOException{
		CFEFilter filter = new CFEFilter();
		int i= dao.getCount(CFEBean.class, filter);
		BigInteger big = new BigInteger(""+i);
		return big;
	}


	private BigInteger getCantDocsMayorTopeEstablecido(int tipoCFE,
			InGenerarReporte in) throws DAOException {
		CFEFilter filter = new CFEFilter();
		
		filter.setMaximoTopeEstablecido(in.getMontoTope());
		int i= dao.getCount(CFEBean.class, filter);
		BigInteger big = new BigInteger(""+i);
		return big;
	}


	private BigInteger getCantDocsAnulados(int tipoCFE,
			InGenerarReporte in) throws DAOException {
		GenericFilter filter = new GenericFilter();
		filter.setProperty("tipoCFE",tipoCFE);
		filter.setProperty("Date(timeStamp)", new Date());
		filter.setProperty("anulados", Boolean.TRUE);
		int cantidad = dao.getCount(CFEBean.class,filter);
		return new BigInteger(""+cantidad);
	}


	private MontosFyT getMontos(int tipoCFE) throws DAOException {
		GenericFilter filter = new GenericFilter();
		filter.setProperty("tipoCFE",tipoCFE);
		filter.setProperty("Date(timeStamp)", new Date());
		MontosFyT monto = new MontosFyT();
		ArrayList<TotalItem> lista = dao.getTotals(CFEBean.class,"codigoSucursal","sum(montoTotal)");
		for (TotalItem item: lista){
			MntsFyTItem mntItem = getMntFyTItem(item);
			monto.getMntsFyTItem().add(mntItem);
		}
		return monto;
	}


	private MntsFyTItem getMntFyTItem(TotalItem item) {
		// TODO Auto-generated method stub
		MntsFyTItem mntItem = new MntsFyTItem();
		BigInteger cod = item.getBigInteger("codigoSucursal");
		mntItem.setCodSuc(cod);
		mntItem.setFecha(getFechaResumen());
		mntItem.setMntIVAOtra(item.getBigDecimal("mntIVAOtra"));
		mntItem.setMntIVATasaBas(item.getBigDecimal("mntIVATasaBas"));
		mntItem.setMntIVATasaMin(item.getBigDecimal("mntIVATasaBas"));
		mntItem.setTotMntExpyAsim(item.getBigDecimal("mntExpyAsim"));
		mntItem.setTotMntImpPerc(item.getBigDecimal("mntImpPerc"));
		mntItem.setTotMntIVAenSusp(item.getBigDecimal("mntIVAenSusp"));
		mntItem.setTotMntIVAOtra(item.getBigDecimal(""));
	//	item.getProperty("codigoSucursal");
		return mntItem;
	}


	private BigInteger getCantDocsUtilizados(int tipoCFE,
			List<CFEBean> cfe) throws DAOException {
		GenericFilter filter = new GenericFilter();
		filter.setProperty("tipoCFE",tipoCFE);
		filter.setProperty("Date(timeStamp)", new Date());
		int cantidad = dao.getCount(CFEBean.class,filter);
		return new BigInteger(""+cantidad);
	}


	private BigInteger getCantDocsMayorTopeEstablecido(int tipoCFE,
			List<CFEBean> cfe,BigInteger montoMaximo) throws DAOException {
		GenericFilter filter = new GenericFilter();
		filter.setProperty("tipoCFE",tipoCFE);
		filter.setProperty("montoTotal < ",montoMaximo);
		filter.setProperty("Date(timeStamp)", new Date());
		int cantidad = dao.getCount(CFEBean.class,filter);
		return new BigInteger(""+cantidad);
	}


	private BigInteger getCantDocEmitidos(int tipoCFE,
			List<CFEBean> cfe) {
		// TODO Auto-generated method stub
		return null;
	}


	private MontosFyT getMontos(int tipoCFE, List<CFEBean> cfe) {
		// TODO Auto-generated method stub
		return null;
	}


	private BigInteger getCantDocsAnulados(int tipoCFE,
			List<CFEBean> cfe) throws DAOException {
		GenericFilter filter = new GenericFilter();
		filter.setProperty("tipoCFE",tipoCFE);
		filter.setProperty("anulados",Boolean.TRUE);
		filter.setProperty("Date(timeStamp)", new Date());
		int cantidad = dao.getCount(CFEBean.class,filter);
		return new BigInteger(""+cantidad);
	}


	private MontosFyT getMontosTicketNotaDebito(List<CFEBean> cfe) {
		// TODO Auto-generated method stub
		MontosFyT montos = new MontosFyT();
		List<MntsFyTItem> lista = getMontosFyTItem(CFEBean.ETICKET_NOTA_DEBITO,cfe);
		MntsFyTItem item = new MntsFyTItem();
		
	//	montos.getMntsFyTItem()
		return montos;
	}


	
	
	
	
	private List<MntsFyTItem> getMontosFyTItem(int tipoCFE,
			List<CFEBean> cfe) {
		
		MntsFyTItem item =new MntsFyTItem();
	//	item.setCodSuc()
	//	cfe.get(0).getCfe().getETck().getEncabezado().getEmisor().getCdgDGISucur()
		
		
		return null;
	}




	private RsmnTckContNotaCredito getResumenTicketContNotaCredito(
			List<CFEBean> cfe) {
		// TODO Auto-generated method stub
		return null;
	}


	private RsmnTckNotaCredito getResumenTicketNotaCredito(List<CFEBean> cfe) {
		// TODO Auto-generated method stub
		return null;
	}


	private RsmnTckCont getResumenTicketCont(List<CFEBean> cfe) {
		// TODO Auto-generated method stub
		return null;
	}


	private RsmnRemCont getResumenRemitoCont(List<CFEBean> cfe) {
		// TODO Auto-generated method stub
		return null;
	}


	private RsmnTck getResumenTicket(List<CFEBean> cfe) {
		// TODO Auto-generated method stub
		return null;
	}


	private RsmnResgCont getResumenResguardoCont(List<CFEBean> cfe) {
		// TODO Auto-generated method stub
		return null;
	}


	private RsmnResg getResumenResguardo(List<CFEBean> cfe) {
		// TODO Auto-generated method stub
		return null;
	}


	private RsmnRem getResumenRemito(List<CFEBean> cfe) {
		// TODO Auto-generated method stub
		return null;
	}


	private RsmnFacNotaDebito getResumenFacNotaDebito(List<CFEBean> cfe) {
		// TODO Auto-generated method stub
		return null;
	}


	private RsmnFacNotaCredito getResumenFacNotaCredito(List<CFEBean> cfe) {
		// TODO Auto-generated method stub
		return null;
	}


	private RsmnFacContNotaDebito getResumenFacContNotaDebito(List<CFEBean> cfe) throws DAOException {
		// TODO Auto-generated method stub
		RsmnFacContNotaDebito res = new RsmnFacContNotaDebito();
		RsmnDataFacCont data = new RsmnDataFacCont();
		data.setCantCFCEmi(getCantDocEmitidos(CFEBean.EFACTURA_NOTA_DEBITO));
		data.setMontos(getMontos(CFEBean.EFACTURA_NOTA_DEBITO));
		res.setRsmnData(data);
		res.setTipoComp(getTipoCFE(CFEBean.EFACTURA_NOTA_DEBITO));
		return res;
	}


	private BigInteger getTipoCFE(int efacNotaDebito) {
		// TODO Auto-generated method stub
		return null;
	}


	private RsmnFacContNotaCredito getResumenFacContNotaCredito(
			List<CFEBean> cfe) throws DAOException {
		RsmnFacContNotaCredito res = new RsmnFacContNotaCredito();
		RsmnDataFacCont data = new  RsmnDataFacCont();
		data.setCantCFCEmi(getCantDocEmitidos(CFEBean.EFACTURA_NOTA_CREDITO));
		data.setMontos(getMontos(CFEBean.EFACTURA_NOTA_CREDITO));
		res.setRsmnData(data);
		res.setTipoComp(getTipoCFE(CFEBean.EFACTURA_NOTA_CREDITO));
		return res;
	}


	private BigInteger getCantDocEmitidos(BigInteger efacNotaCredito) {
		// TODO Auto-generated method stub
		return null;
	}


	private RsmnFacCont getResumenFacCont(List<CFEBean> cfe) {
		// TODO Auto-generated method stub
		return null;
	}


	private RsmnFac getResumenFac(List<CFEBean> cfe) {
		// TODO Auto-generated method stub
		return null;
	}


	private Caratula getCaratula(InGenerarReporte in) {
		Caratula caratula = new Caratula();
		caratula.setFechaResumen(getFechaResumen());
		caratula.setRUCEmisor(in.getRucEmisor());
		caratula.setCantComprobantes(getCantComprobantes(in.getRucEmisor()));
		caratula.setIDEmisor(getIdEmisor());
		caratula.setSecEnvio(getSecuenciaEnvio());
		caratula.setTmstFirmaEnv(getTimeStampSobre());
		caratula.setVersion("1.0");
		return caratula;
		
	}


	private XMLGregorianCalendar getTimeStampSobre() {
		return XMLGregorianCalendarConverter.asXMLGregorianCalendar(new Date());
	}


	private BigInteger getSecuenciaEnvio() {
		// TODO Auto-generated method stub
		return null;
	}


	private BigInteger getIdEmisor() {
		// TODO Auto-generated method stub
		return null;
	}


	private XMLGregorianCalendar getFechaResumen() {
		return XMLGregorianCalendarConverter.asXMLGregorianCalendar(new Date());
	}


	private BigInteger getCantComprobantes(String rucEmisor) {
		// TODO Auto-generated method stub
		
		return null;
	}




}
