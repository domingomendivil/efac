package xg.beans;

import java.util.Date;

import uy.gub.dgi.cfe.CAEdefType;
import xg.xml.XMLMarshallerImpl;
import xg.xml.XMLMarshallerException;

public class CAEBean {
	
	
	
	public CAEBean(String xml) throws XMLMarshallerException{
		CAEdefType aCae = (CAEdefType)new XMLMarshallerImpl().marshall(CAEdefType.class,xml);
		this.cae=aCae;
		this.desdeNumero=aCae.getDA().getDNro().intValue();
		this.hastaNumero=aCae.getDA().getHNro().intValue();
		this.fecha = new Date();
		this.tipoCFE = aCae.getDA().getTCFE().intValue();
		
	}
	
	
	
	
	public boolean equals(Object obj) {
		if (obj instanceof CAEBean){
			CAEBean bean = (CAEBean)obj;
			if (bean.getCae().getSignature().getSignatureValue().equals(this.cae.getSignature().getSignatureValue())){
				return true;
			}else{
				return false;
			}
		}else{
			return false;
		}
		
	}


	private boolean actual;


	public boolean isActual() {
		return actual;
	}




	public void setActual(boolean actual) {
		this.actual = actual;
	}


	private int desdeNumero;
	private int hastaNumero;

	public int getDesdeNumero() {
		return desdeNumero;
	}

	public void setDesdeNumero(int desdeNumero) {
		this.desdeNumero = desdeNumero;
	}

	public int getHastaNumero() {
		return hastaNumero;
	}

	public void setHastaNumero(int hastaNumero) {
		this.hastaNumero = hastaNumero;
	}


	private CAEdefType cae;
	private Date fecha;
	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	private int tipoCFE;

	public int getTipoCFE() {
		return tipoCFE;
	}

	public void setTipoCFE(int tipoCFE) {
		this.tipoCFE = tipoCFE;
	}


	public CAEdefType getCae() {
		return cae;
	}

	public void setCae(CAEdefType cae) {
		this.cae = cae;
	}
	
	

}
