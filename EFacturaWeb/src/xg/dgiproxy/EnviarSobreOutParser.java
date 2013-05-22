package xg.dgiproxy;

import generated.Respuestas;

import java.io.ByteArrayInputStream;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.InputSource;

import uy.gub.dgi.WSEFacturaEFACRECEPCIONSOBREResponse;
import uy.gub.dgi.cfe.ACKSobredefType;
import xg.beans.RespuestaSobreBean;

public class EnviarSobreOutParser {

	public RespuestaSobreBean parse(WSEFacturaEFACRECEPCIONSOBREResponse response) throws Exception {
		RespuestaSobreBean env = new RespuestaSobreBean();
		String xmlData= response.getDataout().getXmlData();
		Document doc = getXMLDocument(xmlData);
		Element element=doc.getDocumentElement();
		System.out.println("element "+element.getNodeName());
		if (element.getNodeName().equals("Respuestas")){
			env.setOk(false);
			env.setRespuestas(getRespuestas(xmlData));
		}else{
			env.setOk(true);
			ACKSobredefType ackSobre = getACKSobre(xmlData);
			env.setAckSobre(ackSobre);
		}
		
		return env;
	}
	
	
	private ACKSobredefType getACKSobre(String xmlData) throws Exception{
		JAXBContext jc = JAXBContext.newInstance(ACKSobredefType.class);
		Unmarshaller unmarshaller = jc.createUnmarshaller();
		ByteArrayInputStream bs= new ByteArrayInputStream(xmlData.getBytes("utf-8"));
		InputSource is = new InputSource(bs);
		ACKSobredefType ack = (ACKSobredefType)unmarshaller.unmarshal(is);
		return ack;
	}
	
	
	private Respuestas getRespuestas(String xmlData) throws Exception{
		JAXBContext jc = JAXBContext.newInstance(Respuestas.class);
		Unmarshaller unmarshaller = jc.createUnmarshaller();
		ByteArrayInputStream bs= new ByteArrayInputStream(xmlData.getBytes("utf-8"));
		InputSource is = new InputSource(bs);
		Respuestas res = (Respuestas)unmarshaller.unmarshal(is);
		return res;
	}


	private Document getXMLDocument(String xmlData) throws Exception {
		DocumentBuilderFactory factory = DocumentBuilderFactory
				.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		
		InputSource is = new InputSource(new ByteArrayInputStream(xmlData.getBytes("utf-8")));
		System.out.println(xmlData);
		Document d = builder.parse(is);
		return d;
	}

}
