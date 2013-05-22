package xg.caebusiness;

import java.util.ArrayList;

import uy.gub.dgi.dao.DAO;
import uy.gub.dgi.dao.DAOException;
import xg.beans.CAEBean;
import xg.beans.CAEUtilizadoBean;
import xg.beans.CFEBean;
import xg.dao.CAEFilter;

public class CAEBusinessImpl implements CAEBusiness{
	
	private DAO dao;
	
	public CAEBusinessImpl(GeneralConfiguration generalConfiguration,DAO dao){
		this.dao=dao;
	}
	
	public void insertarCAE(String xmlFile) throws CAEBusinessException{
		try {
			CAEBean cae =new CAEBean(xmlFile);
			dao.insert(cae);
		} catch (Exception e) {
			throw new CAEBusinessException(e);
		}
	}
	
	public CAEUtilizadoBean getCAE(int tipoCFE) throws CAEBusinessException{
		CAEFilter filter = new CAEFilter();
		filter.setTipoCFE(tipoCFE);
		filter.setActual(true);
		ArrayList lista;
		try {
			lista = dao.getByFilter(filter, CAEUtilizadoBean.class, CAEUtilizadoBean.class);
			if (lista==null) {
				throw new CAEBusinessException("No se encontraron CAEs disponibles");
			}else if (lista.size()<=0){
				throw new CAEBusinessException("No se encontraron CAEs disponibles");
			}else{
				CAEUtilizadoBean cae = (CAEUtilizadoBean)lista.get(0);
				if (cae.getUltimoNumero()<cae.getCae().getHastaNumero()){
					return cae;	
				}else{
					filter.setActual(false);
					ArrayList listaRes = dao.getByFilter(filter,CAEBean.class,CAEBean.class);
					if (listaRes ==null){
						throw new CAEBusinessException("No se encontraron números disponibles");	
					}else if (listaRes.size()<=0){
						throw new CAEBusinessException("No se encontraron números disponibles");
					}else{
						CAEBean bean  = (CAEBean)listaRes.get(0);
						cae.setCae(bean);
						return cae;
					}
					
				}
				
			}
		} catch (DAOException e) {
			throw new CAEBusinessException(e);
		}
	}
	
	
	private void incrementar(CAEUtilizadoBean cae) throws CAEBusinessException{
		cae.setUltimoNumero(cae.getUltimoNumero()+1);
		try{
			if (cae.getUltimoNumero()==cae.getCae().getHastaNumero()){
				CAEFilter filter = new CAEFilter();
				filter.setTipoCFE(cae.getTipoCFE());
				filter.setOrderByFecha(true);
				ArrayList<CAEBean> lista = dao.getByFilter(filter, CAEBean.class, CAEBean.class);
				if (lista!=null){
					CAEBean nuevoCAE = lista.get(0);
					cae.setCae(nuevoCAE);
					if (nuevoCAE !=null){
						dao.update(cae);
					}
				}
			}
			dao.update(cae);
		}catch (Exception e){
			throw new CAEBusinessException(e);
		}

	}

	@Override
	public void insertarCFE(CFEBean cfe) throws CAEBusinessException {
		// TODO Auto-generated method stub
		
	}
	

}
