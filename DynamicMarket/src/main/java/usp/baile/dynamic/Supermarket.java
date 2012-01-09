package usp.baile.dynamic;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public interface Supermarket {

	/**
	 * Purchase an item from the supermarket
	 * @param item the identification of the item to be bought
	 * @param client the identification of the consumer
	 */
	@WebMethod
	public void purchase(String item, String client);
	
	/**
	 * Look for an item in the supermarket
	 * @param item the identification of the item
	 * @return how much the item is; return <code>"NULL"</code> if not available
	 */
	@WebMethod
	public String findItem(String item);
}
