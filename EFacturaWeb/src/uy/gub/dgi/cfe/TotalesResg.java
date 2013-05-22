//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2013.01.14 at 10:23:17 AM UYST 
//


package uy.gub.dgi.cfe;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Totales_Resg complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Totales_Resg">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="TpoMoneda" type="{http://cfe.dgi.gub.uy}TipMonType"/>
 *         &lt;element name="TpoCambio" type="{http://cfe.dgi.gub.uy}TipCambioType" minOccurs="0"/>
 *         &lt;element name="MntTotRetenido" type="{http://cfe.dgi.gub.uy}Monto_admite_negType"/>
 *         &lt;element name="CantLinDet">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://cfe.dgi.gub.uy}LineasDetType">
 *               &lt;totalDigits value="3"/>
 *               &lt;fractionDigits value="0"/>
 *               &lt;maxInclusive value="200"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="RetencPercep" maxOccurs="20">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="CodRet" type="{http://cfe.dgi.gub.uy}CodRetType"/>
 *                   &lt;element name="ValRetPerc" type="{http://cfe.dgi.gub.uy}Monto_admite_negType"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Totales_Resg", propOrder = {
    "tpoMoneda",
    "tpoCambio",
    "mntTotRetenido",
    "cantLinDet",
    "retencPercep"
})
public class TotalesResg {

    @XmlElement(name = "TpoMoneda", required = true)
    protected TipMonType tpoMoneda;
    @XmlElement(name = "TpoCambio")
    protected BigDecimal tpoCambio;
    @XmlElement(name = "MntTotRetenido", required = true)
    protected BigDecimal mntTotRetenido;
    @XmlElement(name = "CantLinDet")
    protected int cantLinDet;
    @XmlElement(name = "RetencPercep", required = true)
    protected List<TotalesResg.RetencPercep> retencPercep;

    /**
     * Gets the value of the tpoMoneda property.
     * 
     * @return
     *     possible object is
     *     {@link TipMonType }
     *     
     */
    public TipMonType getTpoMoneda() {
        return tpoMoneda;
    }

    /**
     * Sets the value of the tpoMoneda property.
     * 
     * @param value
     *     allowed object is
     *     {@link TipMonType }
     *     
     */
    public void setTpoMoneda(TipMonType value) {
        this.tpoMoneda = value;
    }

    /**
     * Gets the value of the tpoCambio property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getTpoCambio() {
        return tpoCambio;
    }

    /**
     * Sets the value of the tpoCambio property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setTpoCambio(BigDecimal value) {
        this.tpoCambio = value;
    }

    /**
     * Gets the value of the mntTotRetenido property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getMntTotRetenido() {
        return mntTotRetenido;
    }

    /**
     * Sets the value of the mntTotRetenido property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setMntTotRetenido(BigDecimal value) {
        this.mntTotRetenido = value;
    }

    /**
     * Gets the value of the cantLinDet property.
     * 
     */
    public int getCantLinDet() {
        return cantLinDet;
    }

    /**
     * Sets the value of the cantLinDet property.
     * 
     */
    public void setCantLinDet(int value) {
        this.cantLinDet = value;
    }

    /**
     * Gets the value of the retencPercep property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the retencPercep property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRetencPercep().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TotalesResg.RetencPercep }
     * 
     * 
     */
    public List<TotalesResg.RetencPercep> getRetencPercep() {
        if (retencPercep == null) {
            retencPercep = new ArrayList<TotalesResg.RetencPercep>();
        }
        return this.retencPercep;
    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="CodRet" type="{http://cfe.dgi.gub.uy}CodRetType"/>
     *         &lt;element name="ValRetPerc" type="{http://cfe.dgi.gub.uy}Monto_admite_negType"/>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "codRet",
        "valRetPerc"
    })
    public static class RetencPercep {

        @XmlElement(name = "CodRet", required = true)
        protected String codRet;
        @XmlElement(name = "ValRetPerc", required = true)
        protected BigDecimal valRetPerc;

        /**
         * Gets the value of the codRet property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getCodRet() {
            return codRet;
        }

        /**
         * Sets the value of the codRet property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setCodRet(String value) {
            this.codRet = value;
        }

        /**
         * Gets the value of the valRetPerc property.
         * 
         * @return
         *     possible object is
         *     {@link BigDecimal }
         *     
         */
        public BigDecimal getValRetPerc() {
            return valRetPerc;
        }

        /**
         * Sets the value of the valRetPerc property.
         * 
         * @param value
         *     allowed object is
         *     {@link BigDecimal }
         *     
         */
        public void setValRetPerc(BigDecimal value) {
            this.valRetPerc = value;
        }

    }

}
