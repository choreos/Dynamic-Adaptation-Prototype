package usp.baile.greeting;

import javax.xml.ws.Endpoint;

public class Launch {

	public static void main(String[] args) {

		System.out.print("Starting services...");
		
		Greeting service1 = new GreetingEn();
		Endpoint endpoint1 = Endpoint.create(service1);
		endpoint1.publish("http://localhost:1234/hello");
		
		Greeting service2 = new GreetingPt();
		Endpoint endpoint2 = Endpoint.create(service2);
		endpoint2.publish("http://localhost:1235/oi");
		
		Greeting service3 = new GreetingIt();
		Endpoint endpoint3 = Endpoint.create(service3);
		endpoint3.publish("http://localhost:1236/ciao");
		
		Greeting service4 = new GreetingProxy();
		Endpoint endpoint4 = Endpoint.create(service4);
		endpoint4.publish("http://localhost:1237/greeting");
		
		Addresser service5 = new GreetingAddresser();
		Endpoint endpoint5 = Endpoint.create(service5);
		endpoint5.publish("http://localhost:1238/addresser");
		
		System.out.println("done!");
	}

}
