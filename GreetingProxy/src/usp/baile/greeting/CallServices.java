package usp.baile.greeting;

import java.io.IOException;

import org.apache.xmlbeans.XmlException;

import eu.choreos.vv.clientgenerator.WSClient;
import eu.choreos.vv.exceptions.FrameworkException;
import eu.choreos.vv.exceptions.InvalidOperationNameException;
import eu.choreos.vv.exceptions.WSDLException;

public class CallServices {

	public static void main(String[] args) throws WSDLException, XmlException, IOException, FrameworkException, InvalidOperationNameException, NoSuchFieldException {

		System.out.println("Calling services...");
		
		WSClient client1 = new WSClient("http://localhost:1234/hello?wsdl");
		WSClient client2 = new WSClient("http://localhost:1235/oi?wsdl");
		WSClient client3 = new WSClient("http://localhost:1236/ciao?wsdl");
		WSClient client5 = new WSClient("http://localhost:1238/addresser?wsdl");
		WSClient client4 = new WSClient("http://localhost:1237/greeting?wsdl");

		client1.request("greet", "John");
		client2.request("greet", "Manoel");
		client3.request("greet", "Antonia");
		client5.request("getEndpoint");
		client4.request("greet", "Dejan");
	}
	
}
