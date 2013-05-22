package xg.xml;

import java.io.ByteArrayInputStream;
import java.io.OutputStream;
import java.io.StringWriter;
import java.security.KeyException;
import java.security.KeyStore;
import java.security.KeyStore.ProtectionParameter;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.cert.Certificate;
import java.util.Collections;

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
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.xml.sax.InputSource;

public class XMLSignerImpl implements XMLSigner {
	
	private PrivateKey privateKey;
	private Certificate certificate;
	
	

	private static PublicKey getPublicKey() throws Exception{
	
		System.out.println("getPublicKey");
		 KeyStore ks = KeyStore.getInstance(KeyStore.getDefaultType());



		    java.io.FileInputStream fis = null;
		    try {
		        fis = new java.io.FileInputStream("C:/Users/d0178/workspace/efactura/classes/agesic_prod_saml.jks");
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
		        fis = new java.io.FileInputStream("C:/Users/d0178/workspace/efactura/classes/agesic_prod_saml.jks");
		        ks.load(fis,"pep1to".toCharArray());
		    } finally {
		        if (fis != null) {
		            fis.close();
		        }
		    }
		    
			// get my private key
			ProtectionParameter p = new KeyStore.PasswordProtection("pep1to".toCharArray());
		    KeyStore.PrivateKeyEntry pkEntry = (KeyStore.PrivateKeyEntry)
		        ks.getEntry("prod.dgi.gub.uy",p);
		    PrivateKey myPrivateKey = pkEntry.getPrivateKey();

		 return myPrivateKey;   
		
	}
	public XMLSignerImpl(PrivateKey privateKey,Certificate certificate){
		this.privateKey=privateKey;
		this.certificate=certificate;
	}
	
	
	public String sign(String xmlData) throws XMLSignerException{
		Document d;
		try{
			DocumentBuilderFactory factory = DocumentBuilderFactory
					.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
//			InputSource is = new InputSource(new StringReader(xmlData));
			
			ByteArrayInputStream inputStream=new ByteArrayInputStream(xmlData.getBytes("utf-8"));
			d = builder.parse(new InputSource(inputStream));

			String xmlRes = signXMLDocument(d.getDocumentElement());
			return xmlRes;
			
		}catch (Exception e){
			e.printStackTrace();
			throw new XMLSignerException(e);
			
		}
	}
	
	
	private  String  signXMLDocument(Node nodo) throws KeyException, Exception{
		XMLSignatureFactory fac = 
				  XMLSignatureFactory.getInstance("DOM"); 

		KeyInfoFactory kif = fac.getKeyInfoFactory(); 
		
		KeyValue kv = kif.newKeyValue(certificate.getPublicKey());
		KeyInfo ki = kif.newKeyInfo(Collections.singletonList(kv)); 

		
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
			return res;
		} catch (TransformerException ex) {
			ex.printStackTrace();
			return null;
		}

	}
	
	

}
