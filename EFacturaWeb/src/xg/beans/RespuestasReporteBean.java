package xg.beans;

import java.util.Date;

import generated.Respuestas;
import uy.gub.dgi.cfe.ReporteDefType;

public class RespuestasReporteBean {
	private Date fecha;
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	private ReporteDefType reporte;
	private Respuestas respuestas;
	private boolean ok;
	public ReporteDefType getReporte() {
		return reporte;
	}
	public void setReporte(ReporteDefType reporte) {
		this.reporte = reporte;
	}
	public Respuestas getRespuestas() {
		return respuestas;
	}
	public void setRespuestas(Respuestas respuestas) {
		this.respuestas = respuestas;
	}
	public boolean isOk() {
		return ok;
	}
	public void setOk(boolean ok) {
		this.ok = ok;
	}
	

}
