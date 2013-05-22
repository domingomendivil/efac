package xg.beans;

public class ReceptorBean {
	
	public final static int RECEPTOR_CORREO=1;
	public final static int RECEPTOR_WEBSERVICE=2;
	
	
	public int getTipo() {
		return tipo;
	}
	public void setTipo(int tipo) {
		this.tipo = tipo;
	}

	private String rut;
	private boolean enviar;
	
	private int tipo;
	
	
	public String getRut() {
		return rut;
	}
	public void setRut(String rut) {
		this.rut = rut;
	}
	public boolean isEnviar() {
		return enviar;
	}
	public void setEnviar(boolean enviar) {
		this.enviar = enviar;
	}

}
