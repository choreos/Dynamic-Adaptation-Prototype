package usp.baile.dynamic;

import javax.jws.WebService;

@WebService(endpointInterface="usp.baile.dynamic.Shipper")
public class Shipper1 implements Shipper {

	@Override
	public void ship(String item, String client, String market) {

		// log
		System.out.println("Shipping item " + item + " for client " + client + " and market " + market);
	}

	@Override
	public String expectedDelivery(String item, String client, String market) {
		
		// log
		System.out.println("Calculating expected time to delivery. " +
				"item " + item + ", client " + client + ", market " + market);
		
		// business rule: delivery date depends of the client first letter
		char key = client.toUpperCase().charAt(0);
		if ((key >= 'A') && (key <= 'D'))
			return "3";
		else if ((key >= 'E') && (key <= 'P'))
			return "12";
		else if ((key >= 'Q') && (key <= 'Z'))
			return "24";
		else if ((key >= '0') && (key <= '9'))
			return "6";
		else
			return "15";
	}

	@Override
	public String howMuch(String item, String client, String market) {
		
		// log
		System.out.println("Calculating how much is the delivery. " +
				"item " + item + ", client " + client + ", market " + market);

		// business rule: delivery date depends of the market last letter
		// business rule: delivery date depends of the client first letter
		char key = market.toUpperCase().charAt(market.length()-1);
		if ((key >= 'A') && (key <= 'D'))
			return "0.5";
		else if ((key >= 'E') && (key <= 'P'))
			return "0.3";
		else if ((key >= 'Q') && (key <= 'Z'))
			return "0.2";
		else if ((key >= '0') && (key <= '9'))
			return "0.1";
		else
			return "1.0";
	}

}
