package xg.dao;

import uy.gub.dgi.dao.Filter;

public class SobreFilter implements Filter{
	
	private int estadoEnvio;

	public int getEstadoEnvio() {
		return estadoEnvio;
	}

	public void setEstadoEnvio(int estadoEnvio) {
		this.estadoEnvio = estadoEnvio;
	}

}
