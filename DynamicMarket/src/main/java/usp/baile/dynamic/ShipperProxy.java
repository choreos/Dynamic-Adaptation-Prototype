package usp.baile.dynamic;

import javax.jws.WebService;

import usp.baile.dynamic.proxy.ClientProvider;
import usp.baile.dynamic.proxy.Requestor;
import eu.choreos.vv.clientgenerator.WSClient;

@WebService(endpointInterface="usp.baile.dynamic.Shipper")
public class ShipperProxy implements Shipper {

	private static String ADDRESSER_ENDPOINT = "http://localhost:1237/addresser?wsdl";
	private static String MY_ROLE = "shipper";
	
	@Override
	public void ship(String item, String client, String market) {
		
		String OPERATION = "ship"; 
		String[] ARGUMENTS = new String[]{item, client, market};

		ClientProvider provider = new ClientProvider(ADDRESSER_ENDPOINT, MY_ROLE);
		WSClient wsclient = provider.getClient();
		Requestor requestor = new Requestor(wsclient);
		requestor.requestVoid(OPERATION, ARGUMENTS);	
	}

	@Override
	public String expectedDelivery(String item, String client, String market) {
		String OPERATION = "expectedDelivery"; 
		String[] ARGUMENTS = new String[]{item, client, market};

		String result = "";
		ClientProvider provider = new ClientProvider(ADDRESSER_ENDPOINT, MY_ROLE);
		WSClient wsclient = provider.getClient();
		Requestor requestor = new Requestor(wsclient);
		result = requestor.requestString(OPERATION, ARGUMENTS);		
		return result;
	}

	@Override
	public String howMuch(String item, String client, String market) {
		String OPERATION = "howMuch"; 
		String[] ARGUMENTS = new String[]{item, client, market};

		String result = "";
		ClientProvider provider = new ClientProvider(ADDRESSER_ENDPOINT, MY_ROLE);
		WSClient wsclient = provider.getClient();
		Requestor requestor = new Requestor(wsclient);
		result = requestor.requestString(OPERATION, ARGUMENTS);		
		return result;
	}

}
