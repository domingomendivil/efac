package xg.generadorsobres;

import java.util.List;

import uy.gub.dgi.cfe.CFEDefType;
import uy.gub.dgi.cfe.EnvioCFE;

public class GenerarSobreOut {
	
	private EnvioCFE envioCFE;

	public void setEnvioCFE(EnvioCFE envioCFE) {
		this.envioCFE=envioCFE;
	}
	
	public EnvioCFE geEnvioCFE(){
		return envioCFE;
	}

	public List<CFEDefType> getCFEs() {
		// TODO Auto-generated method stub
		return null;
	}

}
