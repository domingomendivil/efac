package xg.dgiproxy;

import java.util.List;

import xg.beans.CAEBean;
import xg.beans.CFEBean;
import xg.beans.ReporteBean;
import xg.beans.SobreBean;

public interface DGIProxy {
	
	public void enviarSobre(SobreBean sobre) throws DGIProxyException;
	
	public void enviarReporte(ReporteBean reporte) throws DGIProxyException;
	
	public void consultarEstadoEnvio(SobreBean sobre) throws DGIProxyException;
	
	public CAEBean obtenerCAE(InObtenerCAE in) throws DGIProxyException; 
	
	public List<CFEBean> consultarCFEs(InConsultarCFEs in) throws DGIProxyException;

}
