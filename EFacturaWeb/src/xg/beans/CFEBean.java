package xg.beans;

import java.math.BigDecimal;
import java.util.Date;

import uy.gub.dgi.cfe.ACKCFEdefType;
import uy.gub.dgi.cfe.CFEDefType;
import xg.xml.XMLMarshallerImpl;
import xg.xml.XMLMarshallerException;

public class CFEBean {
	
	public static final int ETICKET = 101;
	public static final int ETICKET_NOTA_DEBITO = 102;
	public static final int ETICKET_NOTA_CREDITO = 103;
	public static final int EFACTURA = 111;
	public static final int EFACTURA_NOTA_CREDITO =  112;
	public static final int EFACTURA_NOTA_DEBITO =  113;
	public static final int EREMITO =  181;
	public static final int ERESGUARDO =  182;
	
	private CFEDefType cfe;
	private ACKCFEdefType ackCFE;
	private boolean anulada;
	private int tipoCFE;
	private int codigoSucursal;
	private Date timeStamp;
	private int estado;
	public int getEstado() {
		return estado;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof CFEBean){
			CFEBean cfe = (CFEBean)obj;
			if (cfe.getCfe().getSignature().getSignatureValue().getValue().equals(this.getCfe().getSignature().getSignatureValue().getValue())){
				return true;
			}else{
				return false;
			}
		}else{
			return false;
		}
	}

	public CFEBean(){
		
	}
	
	public CFEBean(String xml) throws XMLMarshallerException{
		CFEDefType cfe = (CFEDefType)new XMLMarshallerImpl().marshall(CFEDefType.class,xml);
		this.cfe=cfe;
	}
	
	public void setEstado(int estado) {
		this.estado = estado;
	}
	private BigDecimal montoTotal;
	
	
	
	public BigDecimal getMontoTotal() {
		return montoTotal;
	}
	public void setMontoTotal(BigDecimal montoTotal) {
		this.montoTotal = montoTotal;
	}
	public int getTipoCFE() {
		return tipoCFE;
	}
	public void setTipoCFE(int tipoCFE) {
		this.tipoCFE = tipoCFE;
	}
	public Date getTimeStamp() {
		return timeStamp;
	}
	public void setTimeStamp(Date timeStamp) {
		this.timeStamp = timeStamp;
	}
	public int getCodigoSucursal() {
		return codigoSucursal;
	}
	public void setCodigoSucursal(int codigoSucursal) {
		this.codigoSucursal = codigoSucursal;
	}
	public boolean isAnulada() {
		return anulada;
	}
	public void setAnulada(boolean anulada) {
		this.anulada = anulada;
	}
	public CFEDefType getCfe() {
		return cfe;
	}
	public void setCfe(CFEDefType cfe) {
		this.cfe = cfe;
	}
	public ACKCFEdefType getAckCFE() {
		return ackCFE;
	}
	public void setAckCFE(ACKCFEdefType ackCFE) {
		this.ackCFE = ackCFE;
	}
	

	
	
	

}
