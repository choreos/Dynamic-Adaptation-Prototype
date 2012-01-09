package usp.baile.dynamic.util;

import javax.xml.ws.Endpoint;

import usp.baile.dynamic.Addresser;
import usp.baile.dynamic.AddresserImpl;
import usp.baile.dynamic.Shipper;
import usp.baile.dynamic.Shipper1;
import usp.baile.dynamic.Shipper2;
import usp.baile.dynamic.Supermarket;
import usp.baile.dynamic.SupermarketImpl;

public class Launch {

	public static void main(String[] args) {

		System.out.println("Starting market services...");
		
		Supermarket service1 = new SupermarketImpl();
		Endpoint endpoint1 = Endpoint.create(service1);
		endpoint1.publish("http://localhost:1234/market");
		
		Shipper service2 = new Shipper1();
		Endpoint endpoint2 = Endpoint.create(service2);
		endpoint2.publish("http://localhost:1235/shipper1");
		
		Shipper service3 = new Shipper2();
		Endpoint endpoint3 = Endpoint.create(service3);
		endpoint3.publish("http://localhost:1236/shipper2");
		
		Addresser service4 = new AddresserImpl();
		Endpoint endpoint4 = Endpoint.create(service4);
		endpoint4.publish("http://localhost:1237/addresser");
		
//		Supermarket service5 = new SupermarketProxy();
//		Endpoint endpoint5 = Endpoint.create(service5);
//		endpoint5.publish("http://localhost:1238/marketproxy");
//		
//		Shipper service6 = new ShipperProxy();
//		Endpoint endpoint6 = Endpoint.create(service6);
//		endpoint6.publish("http://localhost:1239/shipperproxy");
	}

}
