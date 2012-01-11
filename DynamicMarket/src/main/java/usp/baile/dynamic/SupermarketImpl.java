package usp.baile.dynamic;

import java.util.HashMap;
import java.util.Map;

import javax.jws.WebService;

import org.apache.log4j.Logger;

@WebService(endpointInterface="usp.baile.dynamic.Supermarket")
public class SupermarketImpl implements Supermarket {

	static private Logger logger = Logger.getLogger(SupermarketImpl.class);
	
	// map items => cost
	private static Map<String, String> items = new HashMap<String, String>();
	
	static {
		items.put("milk", "U$1.00");
		items.put("bread", "U$0.50");
		items.put("coffe", "U$1.20");
		items.put("butter", "U$2.00");
	}
	
	
	@Override
	public void purchase(String item, String client) {

		logger.info("Client " + client + " is purchasing item " + item);
	}

	@Override
	public String findItem(String item) {

		logger.info("Looking for item " + item);
		return items.get(item);
	}

	@Override
	public String getName() {

		logger.info("Returning name: WillMart");
		return "WillMart";
	}

}
