package xg.dao;

import java.math.BigDecimal;

import uy.gub.dgi.dao.Filter;

public class CFEFilter implements Filter {
	
	private BigDecimal maximoTopeEstablecido;

	public BigDecimal getMaximoTopeEstablecido() {
		return maximoTopeEstablecido;
	}

	public void setMaximoTopeEstablecido(BigDecimal maximoTopeEstablecido) {
		this.maximoTopeEstablecido = maximoTopeEstablecido;
	}

}
