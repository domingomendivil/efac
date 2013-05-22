package xg.generadorreportes;

import java.math.BigDecimal;
import java.util.List;

import xg.beans.CFEBean;

public class InGenerarReporte {
	
	private List<CFEBean> cfes;
	private String rucEmisor;
	private BigDecimal montoTope;
	
	
	public BigDecimal getMontoTope() {
		return montoTope;
	}
	public void setMontoTope(BigDecimal montoTope) {
		this.montoTope = montoTope;
	}
	public List<CFEBean> getCfes() {
		return cfes;
	}
	public void setCfes(List<CFEBean> cfes) {
		this.cfes = cfes;
	}
	public String getRucEmisor() {
		return rucEmisor;
	}
	public void setRucEmisor(String rucEmisor) {
		this.rucEmisor = rucEmisor;
	}
	
	
	
	

}
