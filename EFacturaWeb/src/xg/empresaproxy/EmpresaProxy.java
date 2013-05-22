package xg.empresaproxy;

import xg.beans.CFEBean;
import xg.beans.SobreBean;

public interface EmpresaProxy {

	public void enviarSobre(SobreBean sobre) throws EmpresaProxyException;
	public void enviarCFE(CFEBean cfe) throws EmpresaProxyException;
	
}
