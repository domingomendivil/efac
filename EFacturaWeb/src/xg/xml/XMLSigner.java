package xg.xml;

public interface XMLSigner {
	
	public String sign(String xmlData) throws XMLSignerException;

}
