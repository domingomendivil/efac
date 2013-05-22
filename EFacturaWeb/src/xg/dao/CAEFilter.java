package xg.dao;

import uy.gub.dgi.dao.Filter;

public class CAEFilter implements Filter {
	
	private int tipoCFE;
	private boolean actual;
	private boolean orderByFecha;
	

	public boolean isActual() {
		return actual;
	}


	public void setActual(boolean actual) {
		this.actual = actual;
	}


	public int getTipoCFE() {
		return tipoCFE;
	}


	public void setTipoCFE(int tipoCFE) {
		this.tipoCFE = tipoCFE;
	}


	public void setOrderByFecha(boolean b) {
		orderByFecha=b;
		
	}




}
