package usp.baile.greeting;

import javax.xml.ws.Endpoint;

public class Launch {

	public static void main(String[] args) {

		System.out.println("Starting services...");
		
		Addresser service1 = new GreetingAddresser();
		Endpoint endpoint1 = Endpoint.create(service1);
		endpoint1.publish("http://localhost:1237/addresser");
	}

}
