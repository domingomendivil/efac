package xg.efacturador;

import java.util.List;

import uy.gub.dgi.cfe.CFEDefTypeX;

public interface EFacturador {
	
	public void generarEFactura(CFEDefTypeX cfe_X) throws EFacturadorException;
	
	public void generarEFactura(List<CFEDefTypeX> cfe_X) throws EFacturadorException;
	 
}
