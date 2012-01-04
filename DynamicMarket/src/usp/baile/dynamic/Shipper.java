package usp.baile.dynamic;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public interface Shipper {

	/**
	 * Order the shipper to ship an item
	 * @param item the item to be shipped
	 * @param client identification of the consumer to who delivery the item
	 * @param market identification of the supermarket that has ordered 
	 */
	@WebMethod
	public void ship(String item, String client, String market);
	
	/**
	 * Verifies the expected time to delivery an item
	 * @param item the item to be shipped
	 * @param client identification of the consumer to who delivery the item
	 * @param market identification of the supermarket that has ordered 
	 * @return the expected time in hours
	 */
	@WebMethod
	public String expectedDelivery(String item, String client, String market);
	
	/**
	 * Verifies how much is to order the delivery
	 * @param item the item to be shipped
	 * @param client identification of the consumer to who delivery the item
	 * @param market identification of the supermarket that has ordered 
	 * @return the delivery cost (in dollars)
	 */
	@WebMethod
	public String howMuch(String item, String client, String market);
}
