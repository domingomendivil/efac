//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2013.01.14 at 10:23:17 AM UYST 
//


package uy.gub.dgi.cfe;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Item_Resg complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Item_Resg">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="NroLinDet">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://cfe.dgi.gub.uy}LineasDetType">
 *               &lt;maxInclusive value="700"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="IndFact">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}positiveInteger">
 *               &lt;totalDigits value="2"/>
 *               &lt;fractionDigits value="0"/>
 *               &lt;enumeration value="1"/>
 *               &lt;enumeration value="2"/>
 *               &lt;enumeration value="3"/>
 *               &lt;enumeration value="4"/>
 *               &lt;enumeration value="5"/>
 *               &lt;enumeration value="6"/>
 *               &lt;enumeration value="7"/>
 *               &lt;enumeration value="9"/>
 *               &lt;enumeration value="10"/>
 *               &lt;enumeration value="11"/>
 *               &lt;enumeration value="12"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="RetencPercep" type="{http://cfe.dgi.gub.uy}RetPerc_Resg" maxOccurs="5" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Item_Resg", propOrder = {
    "nroLinDet",
    "indFact",
    "retencPercep"
})
public class ItemResg {

    @XmlElement(name = "NroLinDet")
    protected int nroLinDet;
    @XmlElement(name = "IndFact", required = true)
    protected BigInteger indFact;
    @XmlElement(name = "RetencPercep")
    protected List<RetPercResg> retencPercep;

    /**
     * Gets the value of the nroLinDet property.
     * 
     */
    public int getNroLinDet() {
        return nroLinDet;
    }

    /**
     * Sets the value of the nroLinDet property.
     * 
     */
    public void setNroLinDet(int value) {
        this.nroLinDet = value;
    }

    /**
     * Gets the value of the indFact property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getIndFact() {
        return indFact;
    }

    /**
     * Sets the value of the indFact property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setIndFact(BigInteger value) {
        this.indFact = value;
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
     * {@link RetPercResg }
     * 
     * 
     */
    public List<RetPercResg> getRetencPercep() {
        if (retencPercep == null) {
            retencPercep = new ArrayList<RetPercResg>();
        }
        return this.retencPercep;
    }

}
