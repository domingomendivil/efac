
package uy.gub.dgi.cfe;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for ReferenciaEl complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ReferenciaEl">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Referencia" maxOccurs="40" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="NroLinRef">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://cfe.dgi.gub.uy}LineasInfoRef">
 *                         &lt;maxInclusive value="40"/>
 *                         &lt;minInclusive value="1"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                   &lt;element name="IndGlobal" minOccurs="0">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}nonNegativeInteger">
 *                         &lt;totalDigits value="1"/>
 *                         &lt;enumeration value="1"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                   &lt;element name="TpoDocRef" type="{http://cfe.dgi.gub.uy}CFEType" minOccurs="0"/>
 *                   &lt;element name="Serie" minOccurs="0">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                         &lt;maxLength value="2"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                   &lt;element name="NroCFERef" type="{http://cfe.dgi.gub.uy}NroCFEType" minOccurs="0"/>
 *                   &lt;element name="RazonRef" minOccurs="0">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                         &lt;maxLength value="90"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                   &lt;element name="FechaCFEref" type="{http://cfe.dgi.gub.uy}FechaType" minOccurs="0"/>
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
@XmlType(name = "ReferenciaEl", propOrder = {
    "referencia"
})
public class ReferenciaEl {

    @XmlElement(name = "Referencia")
    protected List<ReferenciaEl.Referencia> referencia;

    /**
     * Gets the value of the referencia property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the referencia property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getReferencia().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ReferenciaEl.Referencia }
     * 
     * 
     */
    public List<ReferenciaEl.Referencia> getReferencia() {
        if (referencia == null) {
            referencia = new ArrayList<ReferenciaEl.Referencia>();
        }
        return this.referencia;
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
     *         &lt;element name="NroLinRef">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://cfe.dgi.gub.uy}LineasInfoRef">
     *               &lt;maxInclusive value="40"/>
     *               &lt;minInclusive value="1"/>
     *             &lt;/restriction>
     *           &lt;/simpleType>
     *         &lt;/element>
     *         &lt;element name="IndGlobal" minOccurs="0">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}nonNegativeInteger">
     *               &lt;totalDigits value="1"/>
     *               &lt;enumeration value="1"/>
     *             &lt;/restriction>
     *           &lt;/simpleType>
     *         &lt;/element>
     *         &lt;element name="TpoDocRef" type="{http://cfe.dgi.gub.uy}CFEType" minOccurs="0"/>
     *         &lt;element name="Serie" minOccurs="0">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *               &lt;maxLength value="2"/>
     *             &lt;/restriction>
     *           &lt;/simpleType>
     *         &lt;/element>
     *         &lt;element name="NroCFERef" type="{http://cfe.dgi.gub.uy}NroCFEType" minOccurs="0"/>
     *         &lt;element name="RazonRef" minOccurs="0">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *               &lt;maxLength value="90"/>
     *             &lt;/restriction>
     *           &lt;/simpleType>
     *         &lt;/element>
     *         &lt;element name="FechaCFEref" type="{http://cfe.dgi.gub.uy}FechaType" minOccurs="0"/>
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
        "nroLinRef",
        "indGlobal",
        "tpoDocRef",
        "serie",
        "nroCFERef",
        "razonRef",
        "fechaCFEref"
    })
    public static class Referencia {

        @XmlElement(name = "NroLinRef")
        protected int nroLinRef;
        @XmlElement(name = "IndGlobal")
        protected BigInteger indGlobal;
        @XmlElement(name = "TpoDocRef")
        protected BigInteger tpoDocRef;
        @XmlElement(name = "Serie")
        protected String serie;
        @XmlElement(name = "NroCFERef")
        protected BigInteger nroCFERef;
        @XmlElement(name = "RazonRef")
        protected String razonRef;
        @XmlElement(name = "FechaCFEref")
        protected XMLGregorianCalendar fechaCFEref;

        /**
         * Gets the value of the nroLinRef property.
         * 
         */
        public int getNroLinRef() {
            return nroLinRef;
        }

        /**
         * Sets the value of the nroLinRef property.
         * 
         */
        public void setNroLinRef(int value) {
            this.nroLinRef = value;
        }

        /**
         * Gets the value of the indGlobal property.
         * 
         * @return
         *     possible object is
         *     {@link BigInteger }
         *     
         */
        public BigInteger getIndGlobal() {
            return indGlobal;
        }

        /**
         * Sets the value of the indGlobal property.
         * 
         * @param value
         *     allowed object is
         *     {@link BigInteger }
         *     
         */
        public void setIndGlobal(BigInteger value) {
            this.indGlobal = value;
        }

        /**
         * Gets the value of the tpoDocRef property.
         * 
         * @return
         *     possible object is
         *     {@link BigInteger }
         *     
         */
        public BigInteger getTpoDocRef() {
            return tpoDocRef;
        }

        /**
         * Sets the value of the tpoDocRef property.
         * 
         * @param value
         *     allowed object is
         *     {@link BigInteger }
         *     
         */
        public void setTpoDocRef(BigInteger value) {
            this.tpoDocRef = value;
        }

        /**
         * Gets the value of the serie property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getSerie() {
            return serie;
        }

        /**
         * Sets the value of the serie property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setSerie(String value) {
            this.serie = value;
        }

        /**
         * Gets the value of the nroCFERef property.
         * 
         * @return
         *     possible object is
         *     {@link BigInteger }
         *     
         */
        public BigInteger getNroCFERef() {
            return nroCFERef;
        }

        /**
         * Sets the value of the nroCFERef property.
         * 
         * @param value
         *     allowed object is
         *     {@link BigInteger }
         *     
         */
        public void setNroCFERef(BigInteger value) {
            this.nroCFERef = value;
        }

        /**
         * Gets the value of the razonRef property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getRazonRef() {
            return razonRef;
        }

        /**
         * Sets the value of the razonRef property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setRazonRef(String value) {
            this.razonRef = value;
        }

        /**
         * Gets the value of the fechaCFEref property.
         * 
         * @return
         *     possible object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public XMLGregorianCalendar getFechaCFEref() {
            return fechaCFEref;
        }

        /**
         * Sets the value of the fechaCFEref property.
         * 
         * @param value
         *     allowed object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public void setFechaCFEref(XMLGregorianCalendar value) {
            this.fechaCFEref = value;
        }

    }

}
