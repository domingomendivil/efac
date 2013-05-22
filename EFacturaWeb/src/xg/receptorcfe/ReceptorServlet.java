package xg.receptorcfe;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import xg.beans.CFEBean;

public class ReceptorServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String xml = new FileXMLReader().getXMLFile("C:/Users/d0178/workspace/EFacturaWebTest/xmls/CFE.xml");
		
		try {
			CFEBean cfe = new CFEBean(xml);
			ReceptorCFEMail receptor = new ReceptorCFEMail();
			receptor.setHost("192.168.90.131");
			receptor.setEmail("domingo.mendivil@gmail.com");
			receptor.enviarCFE(cfe);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	

}
