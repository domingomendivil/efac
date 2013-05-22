package xg.generador;

import java.util.List;

import uy.gub.dgi.cfe.CFEDefTypeX;
import xg.beans.CFEBean;

public interface Generador {
	
	public CFEBean generarCFE(CFEDefTypeX cfe_x) throws GeneradorException;
	
	public List<CFEBean> generarCFEs(List<CFEDefTypeX> lista) throws GeneradorException;

}
