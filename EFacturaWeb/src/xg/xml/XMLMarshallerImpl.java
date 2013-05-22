package xg.xml;

import java.io.ByteArrayInputStream;
import java.io.OutputStream;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import org.apache.geronimo.mail.util.StringBufferOutputStream;
import org.xml.sax.InputSource;

public class XMLMarshallerImpl implements XMLMarshaller{

	public String unmarshall(Object objeto) throws XMLMarshallerException {
		try {
			JAXBContext jc = JAXBContext.newInstance(objeto.getClass());
			Marshaller marshaller = jc.createMarshaller();
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			StringBuffer buf = new StringBuffer();
			OutputStream output = new StringBufferOutputStream(buf);
			marshaller.marshal(objeto, output);
			return buf.toString();

		} catch (Exception e) {
			throw new XMLMarshallerException(e);
		}
	}

	public Object marshall(Class clase,String xml) throws XMLMarshallerException {

		try {
			JAXBContext jc = JAXBContext.newInstance(clase);
			Unmarshaller unmarshaller = jc.createUnmarshaller();
			ByteArrayInputStream bs = new ByteArrayInputStream(
					xml.getBytes("utf-8"));
			InputSource is = new InputSource(bs);
			Object objeto= unmarshaller.unmarshal(is);
			return objeto;
		} catch (Exception e) {
			throw new XMLMarshallerException(e);
		}
	}

}
