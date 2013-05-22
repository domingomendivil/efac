//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2013.01.14 at 10:23:17 AM UYST 
//


package uy.gub.dgi.cfe;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for RechazoCFE_DGIType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="RechazoCFE_DGIType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Motivo">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://cfe.dgi.gub.uy}MotivoRechazoCFEType">
 *               &lt;maxLength value="3"/>
 *               &lt;enumeration value="E01"/>
 *               &lt;enumeration value="E02"/>
 *               &lt;enumeration value="E03"/>
 *               &lt;enumeration value="E04"/>
 *               &lt;enumeration value="E05"/>
 *               &lt;enumeration value="E07"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="Glosa">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://cfe.dgi.gub.uy}Glosa50Type">
 *               &lt;enumeration value="Tipo y N� de CFE ya fue reportado como anulado"/>
 *               &lt;enumeration value="Tipo y N� de CFE ya existe en los registros"/>
 *               &lt;enumeration value="Tipo y N� de CFE no se corresponden con el CAE"/>
 *               &lt;enumeration value="Firma electr�nica no es v�lida"/>
 *               &lt;enumeration value="No cumple validaciones de Formato comprobantes"/>
 *               &lt;enumeration value="Fecha Firma de CFE no se corresponde con fecha CAE"/>
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
@XmlType(name = "RechazoCFE_DGIType", propOrder = {
    "motivo",
    "glosa"
})
public class RechazoCFEDGIType {

    @XmlElement(name = "Motivo", required = true)
    protected MotivoRechazoCFEType motivo;
    @XmlElement(name = "Glosa", required = true)
    protected String glosa;

    /**
     * Gets the value of the motivo property.
     * 
     * @return
     *     possible object is
     *     {@link MotivoRechazoCFEType }
     *     
     */
    public MotivoRechazoCFEType getMotivo() {
        return motivo;
    }

    /**
     * Sets the value of the motivo property.
     * 
     * @param value
     *     allowed object is
     *     {@link MotivoRechazoCFEType }
     *     
     */
    public void setMotivo(MotivoRechazoCFEType value) {
        this.motivo = value;
    }

    /**
     * Gets the value of the glosa property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGlosa() {
        return glosa;
    }

    /**
     * Sets the value of the glosa property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGlosa(String value) {
        this.glosa = value;
    }

}
