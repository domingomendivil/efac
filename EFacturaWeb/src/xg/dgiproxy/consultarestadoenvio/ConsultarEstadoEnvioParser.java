package xg.dgiproxy.consultarestadoenvio;

import generated.Respuestas;
import uy.gub.dgi.WSEFacturaEFACCONSULTARESTADOENVIOResponse;
import uy.gub.dgi.cfe.ACKCFEdefType;
import xg.beans.RespuestasCFEBean;
import xg.xml.XMLMarshallerException;
import xg.xml.XMLMarshallerImpl;

public class ConsultarEstadoEnvioParser {

	public RespuestasCFEBean parse(
			WSEFacturaEFACCONSULTARESTADOENVIOResponse res) throws ConsultaEstadoEnvioParserException {
		if (res==null)
			throw new ConsultaEstadoEnvioParserException("WSEFacturaEFACCONSULTARESTADOENVIOResponse no puede ser nulo");
		else{
			RespuestasCFEBean out = new RespuestasCFEBean();
			String xmlData = res.getDataout().getXmlData();
			try{
				ACKCFEdefType ack = (ACKCFEdefType)new XMLMarshallerImpl().marshall(ACKCFEdefType.class, xmlData);
				out.setAckCFE(ack);
				out.setOk(true);
				return out;
			}catch(XMLMarshallerException e){
				try {
					Respuestas respuestas = (Respuestas)new XMLMarshallerImpl().marshall(Respuestas.class, xmlData);
					out.setRespuestas(respuestas);
					out.setOk(false);
					out.setAckCFE(null);
					return out;
				} catch (XMLMarshallerException e1) {
					throw new ConsultaEstadoEnvioParserException(e1);
				}
				
			}
		}
	}

}
