package xg.receptorcfe;

import java.util.List;

import xg.beans.CFEBean;
import xg.enviador.EnviadorCFE;
import xg.enviador.EnviadorException;

public class ReceptorCFEWS implements EnviadorCFE{
	
	private String url;
	
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}



	@Override
	public void enviarCFE(List<CFEBean> listaCFEs) throws EnviadorException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void enviarCFE(CFEBean cfe) throws EnviadorException {
		// TODO Auto-generated method stub
		
	}

}
