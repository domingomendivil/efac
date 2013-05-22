package xg.receptorcfe;

import java.util.List;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.Provider;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import xg.beans.CFEBean;
import xg.enviador.EnviadorCFE;
import xg.enviador.EnviadorException;
import xg.xml.XMLMarshallerImpl;

public class ReceptorCFEMail implements EnviadorCFE{
	
	private String email;
	private String host;
	
	public String getHost() {
		return host;
	}

	public void setHost(String ahost) {
		this.host = ahost;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public void enviarCFE(List<CFEBean> listaCFEs) throws EnviadorException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void enviarCFE(CFEBean cfe) throws EnviadorException {
		// TODO Auto-generated method stub
		try{
		    String from = "d0178@dgi.gub.uy";
		    String to = email;

		    // Get system properties
		    Properties props = System.getProperties();

		    // Setup mail server
		    System.out.println("HOST "+host);
		    props.put("mail.smtp.host", host);
		    
			props.put("mail.smtp.user","d0178");

			props.put("mail.smtp.password","ChanchoR");

			props.put("mail.smtp.auth", true);

		    // Get session
		    Session session = 
		      Session.getInstance(props, null);

		    // Define message
		    MimeMessage message = 
		      new MimeMessage(session);
		    message.setFrom(
		      new InternetAddress(from));
		    message.addRecipient(
		      Message.RecipientType.TO, 
		      new InternetAddress(to));
		    message.setSubject(
		      "Envío de Factura");
		    MimeBodyPart messageBodyPart = 
		      new MimeBodyPart();
		    messageBodyPart.setText("Envío de Factura");
		    Multipart multipart = new MimeMultipart();
		    multipart.addBodyPart(messageBodyPart);

		    messageBodyPart = new MimeBodyPart();
		    messageBodyPart.setText(new XMLMarshallerImpl().unmarshall(cfe.getCfe()));
		    multipart.addBodyPart(messageBodyPart);
		    message.setContent(multipart);
		    
			Provider prov = session.getProvider("SMTP");
			System.out.println("PROVIDER "+prov);
			Transport transport = session.getTransport(prov);
			transport.connect(host,"d0178","ChanchoR");
			message.saveChanges();
			transport.sendMessage(message, message.getAllRecipients());
			transport.close();

			
		}catch (Exception e){
			e.printStackTrace();
			throw new EnviadorException(e);
		}
		
	}



}
