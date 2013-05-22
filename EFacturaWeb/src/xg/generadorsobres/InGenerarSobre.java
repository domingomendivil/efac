package xg.generadorsobres;

import java.math.BigInteger;
import java.security.cert.X509Certificate;
import java.util.List;

import xg.beans.CFEBean;

public class InGenerarSobre {
	
	private List<CFEBean> cfe;
	private BigInteger idEmisor;
	private int nro;
	private X509Certificate x509Certificate;
	
	public X509Certificate getX509Certificate() {
		return x509Certificate;
	}
	public void setX509Certificate(X509Certificate x509Certificate) {
		this.x509Certificate = x509Certificate;
	}

	public int getNro() {
		return nro;
	}
	public void setNro(int nro) {
		this.nro = nro;
	}
	public BigInteger getIdEmisor() {
		return idEmisor;
	}
	public void setIdEmisor(BigInteger idEmisor) {
		this.idEmisor = idEmisor;
	}
	
	public List<CFEBean> getCfe_x() {
		return cfe;
	}
	public void setCfe_x(List<CFEBean> cfe_x) {
		this.cfe = cfe_x;
	}


}
