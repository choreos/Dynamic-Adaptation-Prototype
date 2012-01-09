package usp.baile.dynamic.proxy;

import java.io.IOException;

import org.apache.xmlbeans.XmlException;

import eu.choreos.vv.clientgenerator.Item;
import eu.choreos.vv.clientgenerator.WSClient;
import eu.choreos.vv.exceptions.FrameworkException;
import eu.choreos.vv.exceptions.InvalidOperationNameException;

public class ClientProvider {
	
	private String addresserEndpoint, role;

	public ClientProvider(String addresserEndpoint, String role) {
		this.addresserEndpoint = addresserEndpoint;
		this.role = role;
	}

	public WSClient getClient() {
		
		WSClient client = null;
		try {
			WSClient addresser = new WSClient(this.addresserEndpoint);
			Item response = addresser.request("getEndpoint", this.role);
			String partnerLinkEndpoint = response.getChild("return").getContent();
			client = new WSClient(partnerLinkEndpoint + "?wsdl");
			System.out.println("DYNAMIC ENDPOINT: " + partnerLinkEndpoint + "?wsdl");
		} catch (InvalidOperationNameException e) {
			e.printStackTrace();
		} catch (FrameworkException e) {
			e.printStackTrace();
		} catch (NoSuchFieldException e) {
			e.printStackTrace();
		} catch (XmlException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return client;		
	}
	

}
