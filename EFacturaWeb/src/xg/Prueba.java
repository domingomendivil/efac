package xg;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.StringReader;
import java.io.StringWriter;
import java.security.KeyException;
import java.security.KeyStore;
import java.security.KeyStore.ProtectionParameter;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.ResourceBundle;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.crypto.dsig.CanonicalizationMethod;
import javax.xml.crypto.dsig.DigestMethod;
import javax.xml.crypto.dsig.Reference;
import javax.xml.crypto.dsig.SignatureMethod;
import javax.xml.crypto.dsig.SignedInfo;
import javax.xml.crypto.dsig.Transform;
import javax.xml.crypto.dsig.XMLSignature;
import javax.xml.crypto.dsig.XMLSignatureFactory;
import javax.xml.crypto.dsig.dom.DOMSignContext;
import javax.xml.crypto.dsig.keyinfo.KeyInfo;
import javax.xml.crypto.dsig.keyinfo.KeyInfoFactory;
import javax.xml.crypto.dsig.keyinfo.KeyValue;
import javax.xml.crypto.dsig.spec.C14NMethodParameterSpec;
import javax.xml.crypto.dsig.spec.TransformParameterSpec;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
//import javax.xml.soap.SOAPMessage;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.ws.BindingProvider;

import org.apache.cxf.frontend.ClientProxy;
import org.apache.cxf.ws.security.wss4j.WSS4JOutInterceptor;
import org.apache.geronimo.mail.util.StringBufferOutputStream;
import org.apache.ws.security.handler.WSHandlerConstants;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import uy.gub.dgi.Data;
import uy.gub.dgi.WSEFactura;
import uy.gub.dgi.WSEFacturaEFACRECEPCIONSOBRE;
import uy.gub.dgi.WSEFacturaEFACRECEPCIONSOBREResponse;
import uy.gub.dgi.WSEFacturaSoapPort;
import uy.gub.dgi.cfe.CFEDefType;
import uy.gub.dgi.cfe.CFEDefType.EFact;
import uy.gub.dgi.cfe.CFEDefType.EFact.Detalle;
import uy.gub.dgi.cfe.CFEDefType.EFact.Encabezado;
import uy.gub.dgi.cfe.Emisor;
import uy.gub.dgi.cfe.EnvioCFE;
import uy.gub.dgi.cfe.EnvioCFE.Caratula;
import uy.gub.dgi.cfe.ItemDetFact;
import uy.gub.dgi.cfe.MediosPago;
import uy.gub.dgi.cfe.MediosPago.MedioPago;

import com.sun.msv.verifier.jaxp.DocumentBuilderFactoryImpl;


public class Prueba {

/**	private static String getProperty(String prop) {
		ResourceBundle rs = ResourceBundle.getBundle("proxyagesic", Locale.US);
		return rs.getString(prop);
	}

	private static String decrypt(String chain) throws InvalidKeySpecException,
			Exception {

		String password = "secretpassword";
		DESKeySpec key = new DESKeySpec(password.getBytes());
		SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");

		// Instantiate the encrypter/decrypter
		CryptString crypt = new CryptString(keyFactory.generateSecret(key));

		return crypt.decryptBase64(chain);
	}

	private final static void setearAlmacenDeClaves()
			throws InvalidKeySpecException, Exception {
		String clave = decrypt(getProperty("ssl.truststore.password"));
		System.out.println("clave " + clave);

		System.setProperty("javax.net.ssl.trustStore",
				getProperty("ssl.truststore.filepath"));
		System.setProperty("javax.net.ssl.trustStoreType",
				getProperty("ssl.truststore.type"));
		System.setProperty("javax.net.ssl.trustStorePassword",
				decrypt(getProperty("ssl.truststore.password")));
		System.setProperty("javax.net.ssl.keyStore",
				getProperty("ssl.keystore.filepath"));
		System.setProperty("javax.net.ssl.keyStorePassword",
				decrypt(getProperty("ssl.keystore.password")));
		System.setProperty("javax.net.ssl.keyStoreType",
				getProperty("ssl.keystore.type"));
	}

	public final static void main(String[] args) throws InvalidKeySpecException, Exception {
		setearAlmacenDeClaves();
		WSEFacturaSoapPort svcPort = new WSEFactura().getWSEFacturaSoapPort();
		BindingProvider bp = (BindingProvider) svcPort;
		org.apache.cxf.endpoint.Client client = ClientProxy.getClient(svcPort);
		org.apache.cxf.endpoint.Endpoint cxfEndpoint = client.getEndpoint();
		Map<String, Object> outProps = new HashMap<String, Object>();
		outProps.put(WSHandlerConstants.ACTION, WSHandlerConstants.SIGNATURE);
		outProps.put(WSHandlerConstants.USER, "servicios.dgi.red.uy");
		outProps.put(WSHandlerConstants.PW_CALLBACK_CLASS, WSSecHandler.class.getName());
		outProps.put(WSHandlerConstants.SIG_PROP_FILE, "signature.properties");
		outProps.put(WSHandlerConstants.SIG_KEY_ID, "DirectReference");
		WSS4JOutInterceptor wssOut = new WSS4JOutInterceptor(outProps);
		cxfEndpoint.getOutInterceptors().add(wssOut);
		
		bp.getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY,"https://efactura.dgi.gub.uy:6443/ePrueba/ws_eprueba");

		WSEFacturaEFACRECEPCIONSOBRE arg0 = new WSEFacturaEFACRECEPCIONSOBRE();
		Data data = new Data();
		arg0.setDatain(data);
		data.setXmlData(getSobre());
		WSEFacturaEFACRECEPCIONSOBREResponse response= svcPort.efacrecepcionsobre(arg0);
		
		System.out.println(response.getDataout().getXmlData());
		String string;

	
	}
	
	private static String getSobre() throws Exception{
	
		
		EnvioCFE envioCFE = getEnvioCFE();
		
		String resultado = getXMLEnvioCFE(envioCFE);
		
		DocumentBuilderFactory dbf = new DocumentBuilderFactoryImpl();
		ByteArrayInputStream inputStream=new ByteArrayInputStream(resultado.getBytes("utf-8"));
		Document doc = dbf.newDocumentBuilder().parse(new InputSource(inputStream));
		System.out.println("DESPUES: **********");
		System.out.println(doc.toString());
		
		
	
		NodeList nodeList= doc.getElementsByTagName("CFE");
		for (int i=0;i<nodeList.getLength();i++){
			Node nodo = nodeList.item(i);
			String res= signXMLDocument(nodo);
		}
		String nuevo=getStringFromNode(doc);
		System.out.println("------------------------");
		System.out.println("------------------------");
		System.out.println("------------------------");
		System.out.println("NUEVO");
		System.out.println(nuevo);
		return nuevo;
	}
	
	
	private static String getXMLEnvioCFE(EnvioCFE envioCFE) throws JAXBException{
		JAXBContext jc = JAXBContext.newInstance(EnvioCFE.class);
		Marshaller marshaller = jc.createMarshaller();
		marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

		StringBuffer buf = new StringBuffer();
		OutputStream output = new StringBufferOutputStream(buf);
		marshaller.marshal(envioCFE, output);
		return buf.toString();
	}
	
	
	
	
	
	
	
	
	private static EnvioCFE getEnvioCFE() throws JAXBException{
		EnvioCFE envioCFE = new EnvioCFE();
		Caratula caratula = new Caratula();
		
		envioCFE.setCaratula(caratula);
		CFEDefType cfe = new CFEDefType();
		EFact value = new EFact();
		Encabezado encabezado = new Encabezado();
		Emisor emisor = new Emisor();
		emisor.setDomFiscal("Pepe");
		encabezado.setEmisor(emisor);
		value.setEncabezado(encabezado);
		Detalle detalle = new Detalle();
		
		value.setDetalle(detalle);
		cfe.setVersion("1.0");
		cfe.setEFact(value);
		envioCFE.getCFE().add(cfe);
		
		CFEDefType cfe2 = new CFEDefType();
		EFact efact2 = new EFact();
		Encabezado encabezado2 = new Encabezado();
		Emisor emisor2 = new Emisor();
		encabezado2.setEmisor(emisor2);
		efact2.setEncabezado(encabezado2);
		MediosPago mediosPago = new MediosPago();
		MedioPago medioPago = new MedioPago();

		mediosPago.getMedioPago().add(medioPago);
		efact2.setMediosPago(mediosPago);
		Detalle detalle2 = new Detalle();
		ItemDetFact e = new ItemDetFact();
		
		detalle2.getItem().add(e);
		efact2.setDetalle(detalle2);
		cfe2.setEFact(efact2);
		envioCFE.getCFE().add(cfe2);
		System.out.println("***********");
		System.out.println("ENVIO CFE:");
		System.out.println(getXMLEnvioCFE(envioCFE));
		return envioCFE;
	}
	
	
	private Document getDocumentFromMessage(SOAPMessage message) {
		Document d = null;
		// Use SAAJ API to manipulate the SOAP Message
		try {
			ByteArrayOutputStream out = new ByteArrayOutputStream();
			// StringBufferInputStream
			message.writeTo(out);
			System.out.println("OUTPUTSTRING" + out.toString());

			DocumentBuilderFactory factory = DocumentBuilderFactory
					.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			InputSource is = new InputSource(new StringReader(out.toString()));
			d = builder.parse(is);
			System.out.println(""); // just to add a newline
			System.out.println("SOAP HEADER: " + message.getSOAPHeader());
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Exception in handler: " + e);
		}
		return d;
	}
	
	
	private CFEDefType firmarCFE(CFEDefType cfe){
		return null;
	}


	private static PublicKey getPublicKey() throws Exception{
	
		System.out.println("getPublicKey");
		 KeyStore ks = KeyStore.getInstance(KeyStore.getDefaultType());



		    java.io.FileInputStream fis = null;
		    try {
		        fis = new java.io.FileInputStream("C:/Users/d0178/workspace/efactura/classes/almacen.jks");
		        ks.load(fis,"pep1to".toCharArray());
		    } finally {
		        if (fis != null) {
		            fis.close();
		        }
		    }
		    
			ProtectionParameter p = new KeyStore.PasswordProtection("pep1to".toCharArray());
			// get my private key
		    return  ks.getCertificate("*.dgi.gub.uy").getPublicKey();
		
	}

	
	private static PrivateKey getPrivateKey() throws Exception{
		
		 KeyStore ks = KeyStore.getInstance(KeyStore.getDefaultType());


		    java.io.FileInputStream fis = null;
		    try {
		        fis = new java.io.FileInputStream("C:/Users/d0178/workspace/efactura/classes/almacen.jks");
		        ks.load(fis,"pep1to".toCharArray());
		    } finally {
		        if (fis != null) {
		            fis.close();
		        }
		    }
		    
			// get my private key
			ProtectionParameter p = new KeyStore.PasswordProtection("pep1to".toCharArray());
		    KeyStore.PrivateKeyEntry pkEntry = (KeyStore.PrivateKeyEntry)
		        ks.getEntry("servicios.dgi.red.uy",p);
		    PrivateKey myPrivateKey = pkEntry.getPrivateKey();

		 return myPrivateKey;   
		
	}
	
	
	
	
	
	private static String  signXMLDocument(Node nodo) throws KeyException, Exception{
		XMLSignatureFactory fac = 
				  XMLSignatureFactory.getInstance("DOM"); 

		KeyInfoFactory kif = fac.getKeyInfoFactory(); 
		
		KeyValue kv = kif.newKeyValue(getPublicKey());
		KeyInfo ki = kif.newKeyInfo(Collections.singletonList(kv)); 

		
		PrivateKey privateKey = getPrivateKey();
		
		DOMSignContext dsc = new DOMSignContext
				  (privateKey, nodo); 
		
		
		
		Reference ref = fac.newReference
				  ("", fac.newDigestMethod(DigestMethod.SHA1, null),
				    Collections.singletonList
				      (fac.newTransform(Transform.ENVELOPED,
				        (TransformParameterSpec) null)), null, null); 

		SignedInfo si = fac.newSignedInfo
				  (fac.newCanonicalizationMethod
				    (CanonicalizationMethod.INCLUSIVE_WITH_COMMENTS,
				      (C14NMethodParameterSpec) null),
				    fac.newSignatureMethod(SignatureMethod.RSA_SHA1, null),
				    Collections.singletonList(ref));
		
		
		XMLSignature xmlSignature = fac.newXMLSignature(si, ki); 
		
		xmlSignature.sign(dsc); 
		
		
		OutputStream os;

		 os = System.out;
		 
		TransformerFactory tf = TransformerFactory.newInstance();
		Transformer trans = tf.newTransformer();
		trans.transform(new DOMSource(nodo), new StreamResult(os));
		
		return getStringFromNode(nodo);
		
	}
	
	public static String getStringFromNode(Node doc) {
		try {
			DOMSource domSource = new DOMSource(doc);
			StringWriter writer = new StringWriter();
			StreamResult result = new StreamResult(writer);
			TransformerFactory tf = TransformerFactory.newInstance();
			Transformer transformer = tf.newTransformer();
			transformer.transform(domSource, result);
			String res = writer.toString();
			System.out.println("DOCUMENT Message: " + res);
			return res;
		} catch (TransformerException ex) {
			ex.printStackTrace();
			return null;
		}

	}**/
	
	
	

}
