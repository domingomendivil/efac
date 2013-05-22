package xg.dgiproxy;

import java.math.BigInteger;
import java.util.List;

import uy.gub.dgi.Data;
import uy.gub.dgi.WSEFacturaEFACCONSULTARESTADOENVIO;
import uy.gub.dgi.WSEFacturaEFACCONSULTARESTADOENVIOResponse;
import uy.gub.dgi.WSEFacturaEFACRECEPCIONREPORTE;
import uy.gub.dgi.WSEFacturaEFACRECEPCIONREPORTEResponse;
import uy.gub.dgi.WSEFacturaEFACRECEPCIONSOBRE;
import uy.gub.dgi.WSEFacturaEFACRECEPCIONSOBREResponse;
import uy.gub.dgi.WSEFacturaSoapPort;
import uy.gub.dgi.cfe.ConsultaCFE;
import xg.beans.CAEBean;
import xg.beans.CFEBean;
import xg.beans.ReporteBean;
import xg.beans.RespuestaSobreBean;
import xg.beans.RespuestasCFEBean;
import xg.beans.RespuestasReporteBean;
import xg.beans.SobreBean;
import xg.dgiproxy.consultarestadoenvio.ConsultarEstadoEnvioParser;
import xg.xml.XMLMarshallerException;
import xg.xml.XMLMarshallerImpl;

public class DGIProxyImpl implements DGIProxy{

	private WSEFacturaSoapPort wsSoapPort;

	
	

	public DGIProxyImpl(WSEFacturaSoapPort wsSoapPort) throws DGIProxyException{
		this.wsSoapPort = wsSoapPort;
	}
		

	@Override
	public void enviarSobre(SobreBean sobre) throws DGIProxyException {
		if (sobre==null){
			throw new DGIProxyException("El sobre no puede ser nulo");
		}else{
			WSEFacturaEFACRECEPCIONSOBRE in = new WSEFacturaEFACRECEPCIONSOBRE();
			Data data = new Data();
			try {
				data.setXmlData(getXML(sobre.getEnvioCFE()));
				in.setDatain(data);
				WSEFacturaEFACRECEPCIONSOBREResponse res = wsSoapPort.efacrecepcionsobre(in);
				RespuestaSobreBean respuestas = new EnviarSobreOutParser().parse(res);
				sobre.setRespuestaSobre(respuestas);
			} catch (Exception e) {
				throw new DGIProxyException(e);
			}

		}
		
	}



	@Override
	public void enviarReporte(ReporteBean reporte) throws DGIProxyException {
		if (reporte ==null){
			throw new DGIProxyException("El reporte no puede ser nulo");
		}
		else{
				try {
					WSEFacturaEFACRECEPCIONREPORTE in = new WSEFacturaEFACRECEPCIONREPORTE();
					Data data = new Data();
					data.setXmlData(getXML(reporte.getReporte()));
					in.setDatain(data);
					WSEFacturaEFACRECEPCIONREPORTEResponse res = wsSoapPort.efacrecepcionreporte(in);
					RespuestasReporteBean respuestas = new EnviarReporteParser().parse(res);
					reporte.setRespuestas(respuestas);
				} catch (Exception e) {
					throw new DGIProxyException(e);	
				}
		}
	}



	@Override
	public void consultarEstadoEnvio(SobreBean sobre)
			throws DGIProxyException {
		if (sobre ==null){
			throw new DGIProxyException("Sobre no puede ser nulo");
		}else{
			if (sobre.getRespuestaSobre().isOk()){
				BigInteger idReceptor = sobre.getRespuestaSobre().getAckSobre().getCaratula().getIDReceptor();
				byte[] token = sobre.getRespuestaSobre().getAckSobre().getDetalle().getParamConsulta().getToken();
				ConsultaCFE consulta = new ConsultaCFE();
				consulta.setIdReceptor(idReceptor);
				consulta.setToken(getBigInteger(token));
				try {
					WSEFacturaEFACCONSULTARESTADOENVIO in = new WSEFacturaEFACCONSULTARESTADOENVIO();
					Data data = new Data();
					data.setXmlData(getXML(consulta));
					in.setDatain(data);
					WSEFacturaEFACCONSULTARESTADOENVIOResponse res = wsSoapPort.efacconsultarestadoenvio(in);
					RespuestasCFEBean respuestas = new ConsultarEstadoEnvioParser().parse(res);
					sobre.setRespuestasCFE(respuestas);
				} catch (Exception e) {
					throw new DGIProxyException(e);	
				}
			}
		}
	}

	private String getXML(Object objeto) throws XMLMarshallerException {
		return new XMLMarshallerImpl().unmarshall(objeto);
	}

	private BigInteger getBigInteger(byte[] token) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CAEBean obtenerCAE(InObtenerCAE in) throws DGIProxyException {
		String res =null;
		// TODO Auto-generated method stub
		CAEBean cae = new ObtenerCAEParser().parse(res);
		return null;
	}


	@Override
	public List<CFEBean> consultarCFEs(InConsultarCFEs in)
			throws DGIProxyException {
		// TODO Auto-generated method stub
		return null;
	}

}
