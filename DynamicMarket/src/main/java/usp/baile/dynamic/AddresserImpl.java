package usp.baile.dynamic;

import java.util.HashMap;
import java.util.Map;

import javax.jws.WebService;

import org.apache.log4j.Logger;

@WebService(endpointInterface="usp.baile.dynamic.Addresser")
public class AddresserImpl implements Addresser {
	
	private Logger logger = Logger.getLogger(AddresserImpl.class);
	private Map<String, String> endpoints;
	
	private void initMap() {
		
		this.endpoints = new HashMap<String, String>();
		this.endpoints.put("supermarket", "http://localhost:1234/market");
		this.endpoints.put("shipper", "http://localhost:1235/shipper1");
	}
	
	@Override
	public String getEndpoint(String role) {
		
		if (this.endpoints == null)
			this.initMap();
		
		String endpoint = this.endpoints.get(role);
		logger.info("Addresser has returned " + endpoint + " for " + role + " role");
		return endpoint;
	}

	@Override
	public void setEndpoint(String endpoint, String role) {

		if (this.endpoints == null)
			this.initMap();
		
		logger.info("Addresser has set " + endpoint + " for " + role + " role");
		this.endpoints.put(role, endpoint);
	}

	
}
