package usp.baile.dynamic;

import javax.jws.WebService;

import usp.baile.dynamic.proxy.ClientProvider;
import usp.baile.dynamic.proxy.Requestor;
import eu.choreos.vv.clientgenerator.WSClient;

@WebService(endpointInterface="usp.baile.dynamic.Supermarket")
public class SupermarketProxy implements Supermarket {

	private static String ADDRESSER_ENDPOINT = "http://localhost:1237/addresser?wsdl";
	private static String MY_ROLE = "supermarket";
	
	@Override
	public void purchase(String item, String client) {
		
		String OPERATION = "purchase"; 
		String[] ARGUMENTS = new String[]{item, client};

		ClientProvider provider = new ClientProvider(ADDRESSER_ENDPOINT, MY_ROLE);
		WSClient wsclient = provider.getClient();
		Requestor requestor = new Requestor(wsclient);
		requestor.requestVoid(OPERATION, ARGUMENTS);
	}

	@Override
	public String findItem(String item) {

		String OPERATION = "findItem"; 
		String[] ARGUMENTS = new String[]{item};

		String result = "";
		ClientProvider provider = new ClientProvider(ADDRESSER_ENDPOINT, MY_ROLE);
		WSClient wsclient = provider.getClient();
		Requestor requestor = new Requestor(wsclient);
		result = requestor.requestString(OPERATION, ARGUMENTS);		
		return result;
	}

}
