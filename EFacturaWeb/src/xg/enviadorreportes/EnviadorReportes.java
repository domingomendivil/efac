package xg.enviadorreportes;

import uy.gub.dgi.dao.DAO;
import xg.beans.ReporteBean;
import xg.dgiproxy.DGIProxy;
import xg.generadorreportes.GeneradorReportes;
import xg.generadorreportes.InGenerarReporte;

public class EnviadorReportes {
	
	private DGIProxy dgiProxy;
	private GeneradorReportes generadorReportes;
	private DAO dao;
	
	public void enviar(){
		InGenerarReporte in;
		ReporteBean reporte;
		try {
			reporte = generadorReportes.generarReporte();
			dao.insert(reporte);
			dgiProxy.enviarReporte(reporte);
			dao.update(reporte);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
	}

}
