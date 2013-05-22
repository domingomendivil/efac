package xg.beans;

public class DatosBean {
	private String ruc;
	private String razonSocial;
	private int ivaMin;
	private int ivaMax;
	private int totalSobres;
	public String getRuc() {
		return ruc;
	}
	public void setRuc(String ruc) {
		this.ruc = ruc;
	}
	public String getRazonSocial() {
		return razonSocial;
	}
	public void setRazonSocial(String razonSocial) {
		this.razonSocial = razonSocial;
	}
	public int getIvaMin() {
		return ivaMin;
	}
	public void setIvaMin(int ivaMin) {
		this.ivaMin = ivaMin;
	}
	public int getIvaMax() {
		return ivaMax;
	}
	public void setIvaMax(int ivaMax) {
		this.ivaMax = ivaMax;
	}
	public int getTotalSobres() {
		return totalSobres;
	}
	public void setTotalSobres(int totalSobres) {
		this.totalSobres = totalSobres;
	}

}
