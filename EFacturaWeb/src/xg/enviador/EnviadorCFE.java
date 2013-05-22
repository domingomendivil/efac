package xg.enviador;

import java.util.List;

import xg.beans.CFEBean;

public interface EnviadorCFE {
	
	public void enviarCFE(List<CFEBean> listaCFEs) throws EnviadorException;
	
	public void enviarCFE(CFEBean cfe) throws EnviadorException;

}
