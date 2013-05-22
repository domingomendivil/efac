package xg.generadorreportes;

import xg.beans.ReporteBean;

public interface GeneradorReportes {
	
	public ReporteBean generarReporte() throws GeneradorReportesException;

}
