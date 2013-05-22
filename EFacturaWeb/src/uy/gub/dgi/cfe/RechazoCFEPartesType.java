//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2013.01.14 at 10:23:17 AM UYST 
//


package uy.gub.dgi.cfe;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for RechazoCFE_PartesType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="RechazoCFE_PartesType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence maxOccurs="10">
 *         &lt;element name="Motivo">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://cfe.dgi.gub.uy}MotivoRechazoCFEType">
 *               &lt;maxLength value="3"/>
 *               &lt;enumeration value="E02"/>
 *               &lt;enumeration value="E03"/>
 *               &lt;enumeration value="E04"/>
 *               &lt;enumeration value="E05"/>
 *               &lt;enumeration value="E07"/>
 *               &lt;enumeration value="E20"/>
 *               &lt;enumeration value="E21"/>
 *               &lt;enumeration value="E22"/>
 *               &lt;enumeration value="E23"/>
 *               &lt;enumeration value="E24"/>
 *               &lt;enumeration value="E25"/>
 *               &lt;enumeration value="E26"/>
 *               &lt;enumeration value="E27"/>
 *               &lt;enumeration value="E28"/>
 *               &lt;enumeration value="E29"/>
 *               &lt;enumeration value="E30"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="Glosa">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://cfe.dgi.gub.uy}Glosa50Type">
 *             &lt;/restriction>
 *           &lt;/simpleType>
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
@XmlType(name = "RechazoCFE_PartesType", propOrder = {
    "motivoAndGlosa"
})
public class RechazoCFEPartesType {

    @XmlElements({
        @XmlElement(name = "Motivo", required = true, type = MotivoRechazoCFEType.class),
        @XmlElement(name = "Glosa", required = true, type = String.class)
    })
    protected List<Object> motivoAndGlosa;

    /**
     * Gets the value of the motivoAndGlosa property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the motivoAndGlosa property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getMotivoAndGlosa().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link MotivoRechazoCFEType }
     * {@link String }
     * 
     * 
     */
    public List<Object> getMotivoAndGlosa() {
        if (motivoAndGlosa == null) {
            motivoAndGlosa = new ArrayList<Object>();
        }
        return this.motivoAndGlosa;
    }

}
