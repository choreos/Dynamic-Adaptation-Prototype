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
		
		String[] responses = new String[3];
		for (int i=0; i<3; i++) {
			Item item = dynamicClient.request("process", "Dejan");
			responses[i] = item.getChild("result").getContent();
		}
		for (String response: responses)
			System.out.println(response);
	}

}
