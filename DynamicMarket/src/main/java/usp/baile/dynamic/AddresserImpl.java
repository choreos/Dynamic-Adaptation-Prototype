package usp.baile.dynamic;

import javax.jws.WebService;

import org.apache.log4j.Logger;

@WebService(endpointInterface="usp.baile.dynamic.Addresser")
public class AddresserImpl implements Addresser {
	
	static private Logger logger = Logger.getLogger(AddresserImpl.class);
	private static int count = 0;
	private static String marketEndpoint = "http://localhost:1234/market";
	private static String[] shipperEndpoints = {"http://localhost:1235/shipper1", 
										"http://localhost:1236/shipper2"};
	
	@Override
	public String getEndpoint(String role) {
		
		if (role.equals("supermarket"))
			return marketEndpoint;
		
		if (role.equals("shipper")) {
			count++;
			String endpoint = shipperEndpoints[count%shipperEndpoints.length]; 
			// TODO a more complex logic depending on shipper.howMuch and shipper.expectedTime
			// to do this, maybe we will have to change the Addresser interface to something like
			// getEndpoint(String role String... properties) // var args use
			logger.info("Addresser has chosen " + endpoint + " for " + role + " role");
			return endpoint;
		}
		
		return null;
	}

}
