package xg.dgiproxy;

import java.util.Date;

public class InConsultarCFEs {
	
	private int tipoCFE;
	private Date  fechaDesde;
	private Date fechaHasta;
	private String rucEmisor;
	public int getTipoCFE() {
		return tipoCFE;
	}
	public void setTipoCFE(int tipoCFE) {
		this.tipoCFE = tipoCFE;
	}
	public Date getFechaDesde() {
		return fechaDesde;
	}
	public void setFechaDesde(Date fechaDesde) {
		this.fechaDesde = fechaDesde;
	}
	public Date getFechaHasta() {
		return fechaHasta;
	}
	public void setFechaHasta(Date fechaHasta) {
		this.fechaHasta = fechaHasta;
	}
	public String getRucEmisor() {
		return rucEmisor;
	}
	public void setRucEmisor(String rucEmisor) {
		this.rucEmisor = rucEmisor;
	}

}
