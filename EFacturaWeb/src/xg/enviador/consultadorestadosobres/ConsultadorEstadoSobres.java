package xg.enviador.consultadorestadosobres;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.xml.datatype.XMLGregorianCalendar;

import uy.gub.dgi.dao.DAO;
import uy.gub.dgi.dao.DAOException;
import xg.beans.SobreBean;
import xg.caebusiness.GeneralConfiguration;
import xg.dao.SobreFilter;
import xg.dgiproxy.DGIProxy;
import xg.enviador.OnACKCFE;

public class ConsultadorEstadoSobres {
	private DGIProxy dgiProxy;
	private OnACKCFE onACK;
	private DAO dao;
	private GeneralConfiguration config;
	
	
	public ConsultadorEstadoSobres(DGIProxy dgiProxy,OnACKCFE onACK,DAO dao){
		this.dgiProxy=dgiProxy;
		this.onACK=onACK;
		this.dao=dao;
	}
	
	public void consultar() throws ConsultarEstadoSobresException{
		try{
			List<SobreBean> sobres = obtenerSobresPendientes();
			for (SobreBean sobre:sobres){
				dgiProxy.consultarEstadoEnvio(sobre);
				if (sobre.getRespuestasCFE()!=null){
					onACK.onACKCFES(sobre);
				}
			}
		}catch (Exception e){
			throw new ConsultarEstadoSobresException(e);
		}
	}

	private List<SobreBean> obtenerSobresPendientes() throws DAOException {
		SobreFilter filter = new SobreFilter();
		filter.setEstadoEnvio(SobreBean.ESTADO_DGI_ENVIADO);
		ArrayList<SobreBean> sobres = dao.getByFilter(filter, SobreBean.class, SobreBean.class);
		List<SobreBean> res = new ArrayList<SobreBean>();
		for (SobreBean sobre: sobres){
			if (!mayor(sobre.getRespuestaSobre().getAckSobre().getDetalle().getParamConsulta().getFechahora(),config.getFechaActual())){
				res.add(sobre);
			}
		}
		return res;
	}

	private boolean mayor(XMLGregorianCalendar fechahora,
			Date fechaActual) {
		int res= fechahora.toGregorianCalendar().getTime().compareTo(fechaActual);
		if (res < -1){
			return false;
		}else if (res>=0){
			return true;
		}else{
			return true;
		}
	}

}
