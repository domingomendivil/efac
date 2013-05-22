package xg.generadorcfes;

import uy.gub.dgi.cfe.CAEdefType;
import uy.gub.dgi.cfe.CFEDefTypeX;
import xg.beans.CFEBean;

public interface GeneradorCFEs {
	
	public CFEBean generarCFE(CFEDefTypeX cfe_x, CAEdefType cae, int nro) throws GeneradorCFEException;

	
}
