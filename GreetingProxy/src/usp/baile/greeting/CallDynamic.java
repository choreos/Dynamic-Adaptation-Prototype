package usp.baile.greeting;

import java.io.IOException;

import org.apache.xmlbeans.XmlException;

import eu.choreos.vv.clientgenerator.Item;
import eu.choreos.vv.clientgenerator.WSClient;
import eu.choreos.vv.exceptions.FrameworkException;
import eu.choreos.vv.exceptions.InvalidOperationNameException;
import eu.choreos.vv.exceptions.WSDLException;

/**
 *  Invoke the BPEL composition that uses the proxy service
 *
 */
public class CallDynamic {

	public static void main(String[] args) throws WSDLException, XmlException, IOException, FrameworkException, InvalidOperationNameException, NoSuchFieldException {

		// the BPEL composition was deployed on Petals
		WSClient dynamicClient = new WSClient("http://localhost:8084/petals/services/DynamicGreeting?wsdl");
		Item item = dynamicClient.request("process", "Dejan");
		String response = item.getChild("result").getContent();
		System.out.println(response);
		System.exit(0);
	}

}
