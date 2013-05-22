
package org.example.efactura_x;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;
import uy.gub.dgi.cfe.CFEDefTypeX;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the org.example.efactura_x package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _CfeX_QNAME = new QName("http://www.example.org/efactura_x/", "cfe_x");
    private final static QName _OutputGenerarCFE_QNAME = new QName("http://www.example.org/efactura_x/", "output_generarCFE");
    private final static QName _Lista_QNAME = new QName("http://www.example.org/efactura_x/", "lista");
    private final static QName _OutputGenerarCFEs_QNAME = new QName("http://www.example.org/efactura_x/", "output_generarCFEs");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: org.example.efactura_x
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link OutGenerarCFEs }
     * 
     */
    public OutGenerarCFEs createOutGenerarCFEs() {
        return new OutGenerarCFEs();
    }

    /**
     * Create an instance of {@link GenerarCFEs }
     * 
     */
    public GenerarCFEs createGenerarCFEs() {
        return new GenerarCFEs();
    }

    /**
     * Create an instance of {@link GenerarCFE }
     * 
     */
    public GenerarCFE createGenerarCFE() {
        return new GenerarCFE();
    }

    /**
     * Create an instance of {@link ListaCFEX }
     * 
     */
    public ListaCFEX createListaCFEX() {
        return new ListaCFEX();
    }

    /**
     * Create an instance of {@link OutGenerarCFE }
     * 
     */
    public OutGenerarCFE createOutGenerarCFE() {
        return new OutGenerarCFE();
    }

    /**
     * Create an instance of {@link GenerarCFEsResponse }
     * 
     */
    public GenerarCFEsResponse createGenerarCFEsResponse() {
        return new GenerarCFEsResponse();
    }

    /**
     * Create an instance of {@link GenerarCFEResponse }
     * 
     */
    public GenerarCFEResponse createGenerarCFEResponse() {
        return new GenerarCFEResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CFEDefTypeX }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.example.org/efactura_x/", name = "cfe_x")
    public JAXBElement<CFEDefTypeX> createCfeX(CFEDefTypeX value) {
        return new JAXBElement<CFEDefTypeX>(_CfeX_QNAME, CFEDefTypeX.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link OutGenerarCFE }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.example.org/efactura_x/", name = "output_generarCFE")
    public JAXBElement<OutGenerarCFE> createOutputGenerarCFE(OutGenerarCFE value) {
        return new JAXBElement<OutGenerarCFE>(_OutputGenerarCFE_QNAME, OutGenerarCFE.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ListaCFEX }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.example.org/efactura_x/", name = "lista")
    public JAXBElement<ListaCFEX> createLista(ListaCFEX value) {
        return new JAXBElement<ListaCFEX>(_Lista_QNAME, ListaCFEX.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link OutGenerarCFEs }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.example.org/efactura_x/", name = "output_generarCFEs")
    public JAXBElement<OutGenerarCFEs> createOutputGenerarCFEs(OutGenerarCFEs value) {
        return new JAXBElement<OutGenerarCFEs>(_OutputGenerarCFEs_QNAME, OutGenerarCFEs.class, null, value);
    }

}
