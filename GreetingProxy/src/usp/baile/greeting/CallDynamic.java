package usp.baile.greeting;

import java.io.IOException;

import org.apache.xmlbeans.XmlException;

import eu.choreos.vv.clientgenerator.Item;
import eu.choreos.vv.clientgenerator.WSClient;
import eu.choreos.vv.exceptions.FrameworkException;
import eu.choreos.vv.exceptions.InvalidOperationNameException;
import eu.choreos.vv.exceptions.WSDLException;

public class CallDynamic {

	public static void main(String[] args) throws WSDLException, XmlException, IOException, FrameworkException, InvalidOperationNameException, NoSuchFieldException {

		WSClient dynamicClient = new WSClient("http://localhost:1237/greeting?wsdl");
		
		String[] responses = new String[3];
		for (int i=0; i<3; i++) {
			Item item = dynamicClient.request("greet", "Dejan");
			responses[i] = item.getChild("return").getContent();
		}
		for (String response: responses)
			System.out.println(response);
	}

}
