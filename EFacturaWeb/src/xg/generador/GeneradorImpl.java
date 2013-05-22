package xg.generador;

import java.util.ArrayList;
import java.util.List;

import uy.gub.dgi.cfe.CFEDefTypeX;
import uy.gub.dgi.dao.DAO;
import xg.beans.CAEUtilizadoBean;
import xg.beans.CFEBean;
import xg.caebusiness.CAEBusiness;
import xg.generadorcfes.GeneradorCFEs;

public class GeneradorImpl implements Generador {
	
	private CAEBusiness caeBusiness;
	private GeneradorCFEs generadorCFEs;
	
	public GeneradorImpl(CAEBusiness caeBusiness,GeneradorCFEs generadorCFEs,DAO dao){
		this.caeBusiness=caeBusiness;
		this.generadorCFEs=generadorCFEs;
	}

	@Override
	public CFEBean generarCFE(CFEDefTypeX cfe_x) throws GeneradorException {
		List<CFEDefTypeX> lista = new ArrayList<CFEDefTypeX>();
		lista.add(cfe_x);
		List<CFEBean> listaCFEs  = generarCFEs(lista);
		return listaCFEs.get(0);
		
	}

	private int getTipoCFE(CFEDefTypeX cfe_x) {
		return cfe_x.getTipoCFE();
	}

	@Override
	public List<CFEBean> generarCFEs(List<CFEDefTypeX> lista)
			throws GeneradorException {
		List<CFEBean> listaCFEs = new ArrayList<CFEBean>();
		try {
			CAEUtilizadoBean cae =caeBusiness.getCAE(getTipoCFE(lista.get(0)));
			int i = cae.getUltimoNumero();
			for (CFEDefTypeX cfe_x: lista){
				CFEBean cfe =generadorCFEs.generarCFE(cfe_x, cae.getCae().getCae(), i);
				caeBusiness.insertarCFE(cfe);
				i++;
			}
			return listaCFEs;
			
		} catch (Exception e) {
			throw new GeneradorException(e);
		}
	}

}
