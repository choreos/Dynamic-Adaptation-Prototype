package usp.baile.dynamic;

import static org.junit.Assert.*;

import java.io.IOException;

import org.apache.xmlbeans.XmlException;
import org.junit.Test;

import eu.choreos.vv.clientgenerator.Item;
import eu.choreos.vv.clientgenerator.WSClient;
import eu.choreos.vv.exceptions.FrameworkException;
import eu.choreos.vv.exceptions.InvalidOperationNameException;
import eu.choreos.vv.exceptions.WSDLException;

public class BPELTest {

	@Test
	public void testShippers() throws WSDLException, XmlException, IOException, FrameworkException, InvalidOperationNameException, NoSuchFieldException {
		
		WSClient client = new WSClient("http://localhost:8084/petals/services/ShipperProcessService?wsdl");
		Item item = client.request("process", "butter", "Elvis", "WillMart");
		String response = item.getChild("ShipperProcessResponse").getChild("result").getContent();
		
		assertTrue(response.equals("12") || response.equals("24"));
	}

}
