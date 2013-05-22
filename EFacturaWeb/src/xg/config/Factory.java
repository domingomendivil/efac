package xg.config;

import java.security.KeyStore;
import java.security.PublicKey;
import java.security.KeyStore.ProtectionParameter;
import java.security.PrivateKey;
import java.security.cert.Certificate;
import java.security.spec.InvalidKeySpecException;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.ResourceBundle;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.xml.ws.BindingProvider;

import org.apache.cxf.frontend.ClientProxy;
import org.apache.cxf.ws.security.wss4j.WSS4JOutInterceptor;
import org.apache.ws.security.handler.WSHandlerConstants;

import uy.gub.dgi.WSEFactura;
import uy.gub.dgi.WSEFacturaSoapPort;
import uy.gub.dgi.dao.DAO;
import uy.gub.dgi.dao.DAOFactory;
import xg.CryptString;
import xg.dgiproxy.DGIProxy;
import xg.dgiproxy.DGIProxyImpl;
import xg.dgiproxy.WSSecHandler;
import xg.efacturador.EFacturador;
import xg.xml.XMLSignerImpl;

public class Factory {

	public XMLSignerImpl getXMLSigner() throws Exception {
		PrivateKey privateKey = getPrivateKey();
		Certificate certificate = getCertificate();
		XMLSignerImpl xmlSigner = new XMLSignerImpl(privateKey, certificate);
		return xmlSigner;
	}



	private WSS4JOutInterceptor getWSInterceptor() {

		Map<String, Object> outProps = new HashMap<String, Object>();
		outProps.put(WSHandlerConstants.ACTION, WSHandlerConstants.SIGNATURE);
		outProps.put(WSHandlerConstants.USER, "prod.dgi.gub.uy");
		outProps.put(WSHandlerConstants.PW_CALLBACK_CLASS,
				WSSecHandler.class.getName());
		outProps.put(WSHandlerConstants.SIG_PROP_FILE, "signature.properties");
		outProps.put(WSHandlerConstants.SIG_KEY_ID, "DirectReference");
		WSS4JOutInterceptor wssOut = new WSS4JOutInterceptor(outProps);
		return wssOut;
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

	private String getProperty(String prop) {
		ResourceBundle rs = ResourceBundle.getBundle("proxyagesic", Locale.US);
		return rs.getString(prop);
	}

	private void setearAlmacenDeClaves() throws InvalidKeySpecException,
			Exception {
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

	public DGIProxy getDGIProxy() throws Exception {
		setearAlmacenDeClaves();
		String url = getProperty("dgiproxy.url");
		PrivateKey privateKey = getPrivateKey();
		PublicKey publicKey = getCertificate().getPublicKey();
		WSEFacturaSoapPort svcPort = new WSEFactura().getWSEFacturaSoapPort();
		BindingProvider bp = (BindingProvider) svcPort;
		org.apache.cxf.endpoint.Client client = ClientProxy.getClient(svcPort);
		org.apache.cxf.endpoint.Endpoint cxfEndpoint = client.getEndpoint();
		WSS4JOutInterceptor wssOut = getWSInterceptor();
		cxfEndpoint.getOutInterceptors().add(wssOut);
		bp.getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY,
				url);
		DGIProxyImpl dgiProxy = new DGIProxyImpl(svcPort);
		return null;
	}

	public DAO getDAO() {
		return new DAOFactory("efactura").getDAO();
	}

	public EFacturador getEFacturador() {
		// TODO
		return null;
	}

	public Certificate getCertificate() throws FactoryException {
		try {
			System.out.println("getPublicKey");
			KeyStore ks = KeyStore.getInstance(KeyStore.getDefaultType());

			String keyStoreAlias = getProperty("dgiproxy.wssecurity.keystore.certificate.alias");
			java.io.FileInputStream fis = null;
			try {
				String keyStoreDir = getProperty("dgiproxy.wssecurity.keystore.directory");
				String keyStorePwd = getProperty("dgiproxy.wssecurity.keystore.password");

				fis = new java.io.FileInputStream(keyStoreDir);
				ks.load(fis, keyStorePwd.toCharArray());
			} finally {
				if (fis != null) {
					fis.close();
				}
			}
			return ks.getCertificate(keyStoreAlias);
		} catch (Exception e) {
			throw new FactoryException(e);
		}

	}

	private PrivateKey getPrivateKey() throws Exception {

		KeyStore ks = KeyStore.getInstance(KeyStore.getDefaultType());

		java.io.FileInputStream fis = null;

		try {
			fis = new java.io.FileInputStream(
					"C:/Users/d0178/workspace/efactura/classes/agesic_prod_saml.jks");
			ks.load(fis, "pep1to".toCharArray());
		} finally {
			if (fis != null) {
				fis.close();
			}
		}

		// get my private key
		ProtectionParameter p = new KeyStore.PasswordProtection(
				"pep1to".toCharArray());
		KeyStore.PrivateKeyEntry pkEntry = (KeyStore.PrivateKeyEntry) ks
				.getEntry("prod.dgi.gub.uy", p);
		PrivateKey myPrivateKey = pkEntry.getPrivateKey();

		return myPrivateKey;

	}

}
