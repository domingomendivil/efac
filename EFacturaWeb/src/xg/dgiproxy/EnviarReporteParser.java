package xg.dgiproxy;

import uy.gub.dgi.WSEFacturaEFACRECEPCIONREPORTEResponse;
import xg.beans.RespuestasReporteBean;

public class EnviarReporteParser {

	public RespuestasReporteBean parse(
			WSEFacturaEFACRECEPCIONREPORTEResponse response) throws  EnviarReporteOutParserException{
		if (response==null) 
			throw new EnviarReporteOutParserException("WSEFacturaEFACRECEPCIONREPORTEResponse no puede ser nulo");
		else{
			RespuestasReporteBean out = new RespuestasReporteBean();
			return out;
			
		}
	}



}
