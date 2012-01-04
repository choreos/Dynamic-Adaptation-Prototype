package usp.baile.dynamic;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.IOException;

import org.apache.xmlbeans.XmlException;
import org.junit.Test;

import eu.choreos.vv.clientgenerator.Item;
import eu.choreos.vv.clientgenerator.WSClient;
import eu.choreos.vv.exceptions.FrameworkException;
import eu.choreos.vv.exceptions.InvalidOperationNameException;
import eu.choreos.vv.exceptions.WSDLException;

public class BaseServicesTest {

//		WSClient client5 = new WSClient("http://localhost:1238/marketproxy?wsdl");
//		WSClient client6 = new WSClient("http://localhost:1239/shipperproxy?wsdl");
//
//
//		client5.request("findItem", "butter");
//		client6.request("expectedDelivery", "butter", "John", "WillMart");
	
	@Test
	public void testMarket() throws WSDLException, XmlException, IOException, FrameworkException, InvalidOperationNameException, NoSuchFieldException {
		
		WSClient client = new WSClient("http://localhost:1234/market?wsdl");
		Item item = client.request("findItem", "butter");
		String response = item.getChild("return").getContent();
		
		assertEquals("U$2.00", response);
	}

	@Test
	public void testShippers() throws WSDLException, XmlException, IOException, FrameworkException, InvalidOperationNameException, NoSuchFieldException {
		
		WSClient client2 = new WSClient("http://localhost:1235/shipper1?wsdl");
		WSClient client3 = new WSClient("http://localhost:1236/shipper2?wsdl");
		Item item1 = client2.request("expectedDelivery", "butter", "John", "WillMart");
		Item item2 = client3.request("howMuch", "butter", "John", "WillMart");
		String response1 = item1.getChild("return").getContent();
		String response2 = item2.getChild("return").getContent();
		
		assertEquals("12", response1);
		assertEquals("0.1", response2);
	}
	
	@Test
	public void testAddresser() throws WSDLException, XmlException, IOException, FrameworkException, InvalidOperationNameException, NoSuchFieldException {
		
		WSClient client4 = new WSClient("http://localhost:1237/addresser?wsdl");
		Item item1 = client4.request("getEndpoint", "supermarket");
		Item item2 = client4.request("getEndpoint", "shipper");		
		String response1 = item1.getChild("return").getContent();
		String response2 = item2.getChild("return").getContent();
		
		assertEquals("http://localhost:1234/market", response1);
		String uri1 = "http://localhost:1235/shipper1";
		String uri2 = "http://localhost:1236/shipper2";
		assertTrue(response2.equals(uri1) || response2.equals(uri2));
	}
}
