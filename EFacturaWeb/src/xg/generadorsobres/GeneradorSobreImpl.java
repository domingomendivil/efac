package xg.generadorsobres;

import java.security.cert.CertificateEncodingException;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import uy.gub.dgi.cfe.EnvioCFE;
import uy.gub.dgi.cfe.EnvioCFE.Caratula;
import xg.beans.CFEBean;
import xg.beans.SobreBean;

public class GeneradorSobreImpl implements GeneradorSobre {
	
	private int cfesPorSobre;
	
	public GeneradorSobreImpl(int cfesPorSobre){
		this.cfesPorSobre=cfesPorSobre;
	}

	
	@Override
	public List<SobreBean> generarSobre(InGenerarSobre in)
			throws GeneradorSobreException {
		List<SobreBean> lista = new ArrayList<SobreBean>();
		if (in.getCfe_x().size()<cfesPorSobre){
			
		}
		SobreBean sobre = new SobreBean();
		EnvioCFE envioCFE = getEnvioCFE(in);
		sobre.setEnvioCFE(envioCFE);
		return lista;
	}
	
	
	
	private EnvioCFE getEnvioCFE(InGenerarSobre in) throws GeneradorSobreException {
		EnvioCFE envioCFE = new EnvioCFE();
		Caratula caratula;
		try {
			caratula = getCaratula(in);
			envioCFE.setCaratula(caratula);
			envioCFE.setVersion("1.0");
			for (CFEBean cfe:in.getCfe_x()){
				envioCFE.getCFE().add(cfe.getCfe());	
			}
			return envioCFE;
		} catch (Exception e) {
			throw new GeneradorSobreException(e);
		}
	}





	private Caratula getCaratula(InGenerarSobre in) throws CertificateEncodingException, DatatypeConfigurationException{
		Caratula caratula = new Caratula();
		caratula.setCantCFE(in.getCfe_x().size());
		caratula.setRUCEmisor(getRucEmisor(in.getCfe_x()));
		caratula.setRutReceptor(getRucReceptor(in.getCfe_x()));
		caratula.setX509Certificate(in.getX509Certificate().getEncoded());
		caratula.setFecha(getDate());
		caratula.setIdemisor(in.getIdEmisor());
		caratula.setVersion("1.0");

		return caratula;
	}

	
	private String getRucReceptor(List<CFEBean> cfe_x) {
		// TODO Auto-generated method stub
		return null;
	}



	private String getRucEmisor(List<CFEBean> cfe_x) {
		// TODO Auto-generated method stub
		return null;
	}



	private XMLGregorianCalendar getDate() throws DatatypeConfigurationException{
		DatatypeFactory df = DatatypeFactory.newInstance();
		GregorianCalendar gc = new GregorianCalendar();
        gc.setTimeInMillis(new Date().getTime());
        return df.newXMLGregorianCalendar(gc);

		
	}

}
