package xg.beans;

import uy.gub.dgi.cfe.ReporteDefType;

public class ReporteBean {
	
	public ReporteDefType getReporte() {
		return reporte;
	}
	public void setReporte(ReporteDefType reporte) {
		this.reporte = reporte;
	}
	private ReporteDefType reporte;
	private RespuestasReporteBean respuestas;
	public RespuestasReporteBean getRespuestas() {
		return respuestas;
	}
	public void setRespuestas(RespuestasReporteBean respuestas) {
		this.respuestas = respuestas;
	}

}
