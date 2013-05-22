package xg.beans;

public class CAEUtilizadoBean {
	
	private CAEBean cae;
	private int tipoCFE;
	private int ultimoNumero;
	
	
	public int getUltimoNumero() {
		return ultimoNumero;
	}
	public void setUltimoNumero(int ultimoNumero) {
		this.ultimoNumero = ultimoNumero;
	}
	public CAEBean getCae() {
		return cae;
	}
	public void setCae(CAEBean cae) {
		this.cae = cae;
		this.cae.setActual(true);
	}
	public int getTipoCFE() {
		return tipoCFE;
	}
	public void setTipoCFE(int tipoCFE) {
		this.tipoCFE = tipoCFE;
	}

}
