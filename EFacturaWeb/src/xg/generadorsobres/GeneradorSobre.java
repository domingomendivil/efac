package xg.generadorsobres;

import java.util.List;

import xg.beans.SobreBean;

public interface GeneradorSobre {
	
	public List<SobreBean> generarSobre(InGenerarSobre in) throws GeneradorSobreException ;

}
