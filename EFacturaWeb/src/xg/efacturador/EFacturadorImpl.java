package xg.efacturador;

import java.util.ArrayList;
import java.util.List;

import uy.gub.dgi.cfe.CFEDefTypeX;
import uy.gub.dgi.dao.DAO;
import xg.beans.CFEBean;
import xg.enviador.EnviadorCFE;
import xg.generador.Generador;

public class EFacturadorImpl implements EFacturador {
	private Generador generador;
	private EnviadorCFE enviadorCFE;
	
	
	
	public EFacturadorImpl(Generador generador,EnviadorCFE enviador,DAO dao){
		this.generador=generador;
		this.enviadorCFE=enviador;
	}



	@Override
	public void generarEFactura(CFEDefTypeX cfe_X) throws EFacturadorException {
		List<CFEDefTypeX> lista = new ArrayList<CFEDefTypeX>();
		lista.add(cfe_X);
		generarEFactura(lista);
	}



	@Override
	public void generarEFactura(List<CFEDefTypeX> cfe_X)
			throws EFacturadorException {
		try {
			List<CFEBean> cfeBean = generador.generarCFEs(cfe_X);
			enviadorCFE.enviarCFE(cfeBean);
		} catch (Exception e) {
			throw new EFacturadorException(e);
		}
		
	}

}
