package usp.baile.greeting;

import java.io.IOException;

import javax.jws.WebService;

import org.apache.xmlbeans.XmlException;

import eu.choreos.vv.clientgenerator.Item;
import eu.choreos.vv.clientgenerator.WSClient;
import eu.choreos.vv.exceptions.FrameworkException;
import eu.choreos.vv.exceptions.InvalidOperationNameException;
import eu.choreos.vv.exceptions.WSDLException;

@WebService(endpointInterface="usp.baile.greeting.Greeting")
public class GreetingProxy implements Greeting {

	private static String ADDRESSER_ENDPOINT = "http://localhost:1238/addresser?wsdl";
	
	
	@Override
	public String greet(String name) {

		String operation = "greet"; // TODO use some reflexive stuff here

		WSClient addresser = null;
		try {
			addresser = new WSClient(ADDRESSER_ENDPOINT);
		} catch (WSDLException e) {
			e.printStackTrace();
		} catch (XmlException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (FrameworkException e) {
			e.printStackTrace();
		}

		
		Item response;
		String partnerLinkEndpoint = null;
		try {
			response = addresser.request("getEndpoint");
			partnerLinkEndpoint = response.getChild("return").getContent();
			System.out.println("DYNAMIC ENDPOINT: " + partnerLinkEndpoint + "?wsdl");
		} catch (InvalidOperationNameException e) {
			e.printStackTrace();
		} catch (FrameworkException e) {
			e.printStackTrace();
		} catch (NoSuchFieldException e) {
			e.printStackTrace();
		}
		
		String result = "";
		try {
			WSClient service = new WSClient(partnerLinkEndpoint + "?wsdl");
			response = service.request(operation, name);
			result = response.getChild("return").getContent();
		} catch (WSDLException e) {
			e.printStackTrace();
		} catch (XmlException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (FrameworkException e) {
			e.printStackTrace();
		} catch (InvalidOperationNameException e) {
			e.printStackTrace();
		} catch (NoSuchFieldException e) {
			e.printStackTrace();
		}
		
		// TODO aqui tá repassando o conteúdo de "return"
		// mas talvez seja melhor repassar todo o envelope soap
		return result;
	}

}
