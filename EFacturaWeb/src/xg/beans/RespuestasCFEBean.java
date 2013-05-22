package xg.beans;

import java.util.Date;

import generated.Respuestas;
import uy.gub.dgi.cfe.ACKCFEdefType;

public class RespuestasCFEBean {
	
	private Date fecha;
	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	private ACKCFEdefType ackCFE;
	private Respuestas respuestas;
	
	private boolean ok;

	public ACKCFEdefType getAckCFE() {
		return ackCFE;
	}

	public void setAckCFE(ACKCFEdefType ackCFE) {
		this.ackCFE = ackCFE;
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
