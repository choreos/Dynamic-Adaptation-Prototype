package usp.baile.dynamic;

import java.util.Map;

public class SupermarketImpl implements Supermarket {

	// map items => cost
	private static Map<String, String> items;
	
	static {
		items.put("milk", "U$1.00");
		items.put("bread", "U$0.50");
		items.put("coffe", "U$1.20");
		items.put("butter", "U$2.00");
	}
	
	
	@Override
	public void purchase(String item, String client) {

		// DO NOTHING
	}

	@Override
	public String findItem(String item) {

		return items.get(item);
	}

}
