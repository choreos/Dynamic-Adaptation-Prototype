package usp.baile.dynamic;

public interface Shipper {

	/**
	 * Order the shipper to ship an item
	 * @param item the item to be shipped
	 * @param client identification of the consumer to who delivery the item
	 * @param market identification of the supermarket that has ordered 
	 */
	public void ship(String item, String client, String market);
	
	/**
	 * Verifies the expected time to delivery an item
	 * @param item the item to be shipped
	 * @param client identification of the consumer to who delivery the item
	 * @param market identification of the supermarket that has ordered 
	 * @return the expected deliverable date
	 */
	public String expectedDelivery(String item, String client, String market);
	
	/**
	 * Verifies how much is to order the delivery
	 * @param item the item to be shipped
	 * @param client identification of the consumer to who delivery the item
	 * @param market identification of the supermarket that has ordered 
	 * @return the delivery cost
	 */
	public String howMuch(String item, String client, String market);
}
