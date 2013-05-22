package xg.enviador;

import java.math.BigInteger;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;

import uy.gub.dgi.dao.DAO;
import uy.gub.dgi.dao.DAOException;
import xg.beans.CFEBean;
import xg.beans.DatosBean;
import xg.beans.SobreBean;
import xg.dgiproxy.DGIProxy;
import xg.generadorsobres.GeneradorSobre;
import xg.generadorsobres.InGenerarSobre;

public class EnviadorCFEImpl implements EnviadorCFE, OnACKCFE {
	
	private DGIProxy dgiProxy;
	private GeneradorSobre generadorSobre;
	private DAO dao;
	private X509Certificate certificate;
	
	
	
	public EnviadorCFEImpl(X509Certificate certificate,DGIProxy dgiProxy,GeneradorSobre generadorSobre,DAO dao){
		this.dgiProxy=dgiProxy;
		this.generadorSobre=generadorSobre;
		this.dao=dao;
	}
	
	
	@Override
	public void enviarCFE(List<CFEBean> listaCFEs) throws EnviadorException {
		try {
			InGenerarSobre in = new InGenerarSobre();
			in.setCfe_x(listaCFEs);
			in.setIdEmisor(getIdEmisor());
			in.setX509Certificate(certificate);			
			List<SobreBean> sobres = generadorSobre.generarSobre(in);
			for (SobreBean sobre:sobres){
				dao.insert(sobre);
				dgiProxy.enviarSobre(sobre);
				dao.update(sobre);
			}
		} catch (Exception e) {
			throw new EnviadorException(e);
		}
	}
	
	public void onACKCFES(SobreBean sobre) throws OnACKCFEException{
		try {
			dao.update(sobre);
		} catch (DAOException e) {
			throw new OnACKCFEException(e);
		}
	}



	private BigInteger getIdEmisor() throws DAOException {
		DatosBean datos = (DatosBean)dao.getById(null,DatosBean.class);
		return BigInteger.valueOf(datos.getTotalSobres());
	}




	@Override
	public void enviarCFE(CFEBean cfe) throws EnviadorException {
		List<CFEBean> lista = new ArrayList<CFEBean>();
		lista.add(cfe);
		enviarCFE(lista);
	}


	
	

}
