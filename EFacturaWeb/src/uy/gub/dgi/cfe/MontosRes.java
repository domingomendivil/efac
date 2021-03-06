//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2013.01.18 at 12:19:08 PM UYST 
//


package uy.gub.dgi.cfe;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for Montos_Res complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Montos_Res">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Mnts_Res_Item" maxOccurs="200">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="Fecha" type="{http://cfe.dgi.gub.uy}FechaType"/>
 *                   &lt;element name="CodSuc" type="{http://cfe.dgi.gub.uy}CodSucType"/>
 *                   &lt;element name="TotMntRetenido" type="{http://cfe.dgi.gub.uy}Monto_admite_negType"/>
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
@XmlType(name = "Montos_Res", propOrder = {
    "mntsResItem"
})
public class MontosRes {

    @XmlElement(name = "Mnts_Res_Item", required = true)
    protected List<MontosRes.MntsResItem> mntsResItem;

    /**
     * Gets the value of the mntsResItem property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the mntsResItem property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getMntsResItem().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link MontosRes.MntsResItem }
     * 
     * 
     */
    public List<MontosRes.MntsResItem> getMntsResItem() {
        if (mntsResItem == null) {
            mntsResItem = new ArrayList<MontosRes.MntsResItem>();
        }
        return this.mntsResItem;
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
     *         &lt;element name="Fecha" type="{http://cfe.dgi.gub.uy}FechaType"/>
     *         &lt;element name="CodSuc" type="{http://cfe.dgi.gub.uy}CodSucType"/>
     *         &lt;element name="TotMntRetenido" type="{http://cfe.dgi.gub.uy}Monto_admite_negType"/>
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
        "fecha",
        "codSuc",
        "totMntRetenido"
    })
    public static class MntsResItem {

        @XmlElement(name = "Fecha", required = true)
        protected XMLGregorianCalendar fecha;
        @XmlElement(name = "CodSuc", required = true)
        protected BigInteger codSuc;
        @XmlElement(name = "TotMntRetenido", required = true)
        protected BigDecimal totMntRetenido;

        /**
         * Gets the value of the fecha property.
         * 
         * @return
         *     possible object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public XMLGregorianCalendar getFecha() {
            return fecha;
        }

        /**
         * Sets the value of the fecha property.
         * 
         * @param value
         *     allowed object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public void setFecha(XMLGregorianCalendar value) {
            this.fecha = value;
        }

        /**
         * Gets the value of the codSuc property.
         * 
         * @return
         *     possible object is
         *     {@link BigInteger }
         *     
         */
        public BigInteger getCodSuc() {
            return codSuc;
        }

        /**
         * Sets the value of the codSuc property.
         * 
         * @param value
         *     allowed object is
         *     {@link BigInteger }
         *     
         */
        public void setCodSuc(BigInteger value) {
            this.codSuc = value;
        }

        /**
         * Gets the value of the totMntRetenido property.
         * 
         * @return
         *     possible object is
         *     {@link BigDecimal }
         *     
         */
        public BigDecimal getTotMntRetenido() {
            return totMntRetenido;
        }

        /**
         * Sets the value of the totMntRetenido property.
         * 
         * @param value
         *     allowed object is
         *     {@link BigDecimal }
         *     
         */
        public void setTotMntRetenido(BigDecimal value) {
            this.totMntRetenido = value;
        }

    }

}
