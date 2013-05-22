package xg.caebusiness;

import xg.beans.CAEUtilizadoBean;
import xg.beans.CFEBean;

public interface CAEBusiness {
	
	public void insertarCAE(String xmlFile) throws CAEBusinessException;
	
	public CAEUtilizadoBean getCAE(int tipoCFE) throws CAEBusinessException;
	
	public void insertarCFE(CFEBean cfe) throws CAEBusinessException;
}
