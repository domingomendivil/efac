package xg.beans;

import java.util.List;

import uy.gub.dgi.cfe.EnvioCFE;

public class SobreBean {
	
	public final static int ESTADO_DGI_SIN_ENVIAR = 0;
	public final static int ESTADO_DGI_ENVIADO = 1;
	public final static int ESTADO_DGI_ACEPTADO = 2;
	public final static int ESTADO_DGI_RECHAZADO = 3;
	public final static int ESTADO_DGI_ERROR_CONEXION= 4;
	
	public final static int ESTADO_EMPRESA_ENVIADO = 1;
	public final static int ESTADO_EMPRESA_ACEPTADO = 2;
	public final static int ESTADO_EMPRESA_RECHAZADO = 3;
	public final static int ESTADO_EMPRESA_ERROR_CONEXION= 4;
	
	private EnvioCFE envioCFE;
	private List<CFEBean> cfes;

	private RespuestaSobreBean respuestaSobre;
	private RespuestasCFEBean respuestasCFE;
	

	public RespuestasCFEBean getRespuestasCFE() {
		return respuestasCFE;
	}

	public void setRespuestasCFE(RespuestasCFEBean respuestasCFE) {
		this.respuestasCFE = respuestasCFE;
	}

	public RespuestaSobreBean getRespuestaSobre() {
		return respuestaSobre;
	}

	public void setRespuestaSobre(RespuestaSobreBean respuestaSobre) {
		this.respuestaSobre = respuestaSobre;
	}

	private int estadoDGI;
	private int estadoEmpresa;
	
	
	
	
	public int getEstadoEmpresa() {
		return estadoEmpresa;
	}

	public void setEstadoEmpresa(int estadoEmpresa) {
		this.estadoEmpresa = estadoEmpresa;
	}

	public int getEstadoDGI() {
		return estadoDGI;
	}

	public void setEstadoDGI(int estadoDGI) {
		this.estadoDGI = estadoDGI;
	}

	public List<CFEBean> getCfes() {
		return cfes;
	}

	public void setCfes(List<CFEBean> cfes) {
		this.cfes = cfes;
	}


	public EnvioCFE getEnvioCFE() {
		return envioCFE;
	}

	public void setEnvioCFE(EnvioCFE envioCFE) {
		this.envioCFE = envioCFE;
	}
	

}
