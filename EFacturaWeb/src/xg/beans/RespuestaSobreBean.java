package xg.beans;

import java.util.Date;

import generated.Respuestas;
import uy.gub.dgi.cfe.ACKSobredefType;

public class RespuestaSobreBean {
	
	private Date fecha;
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	private ACKSobredefType ackSobre;
	private Respuestas respuestas;
	private boolean ok;
	public ACKSobredefType getAckSobre() {
		return ackSobre;
	}
	public void setAckSobre(ACKSobredefType ackSobre) {
		this.ackSobre = ackSobre;
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
