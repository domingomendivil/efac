package xg.xml;

public interface XMLMarshaller {
	
	public Object marshall(Class clase,String xml) throws XMLMarshallerException;
	
	
	public String unmarshall(Object objeto) throws XMLMarshallerException;
	

}
