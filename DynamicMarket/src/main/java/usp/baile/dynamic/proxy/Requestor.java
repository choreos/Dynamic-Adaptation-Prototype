package usp.baile.dynamic.proxy;

import eu.choreos.vv.clientgenerator.Item;
import eu.choreos.vv.clientgenerator.WSClient;
import eu.choreos.vv.exceptions.FrameworkException;
import eu.choreos.vv.exceptions.InvalidOperationNameException;
import eu.choreos.vv.exceptions.WSDLException;

public class Requestor {
	
	private WSClient client;

	public Requestor(WSClient client) {
		this.client = client;
	}
	
	public void requestVoid(String operation, String[] arguments) {
		try {
			this.client.request(operation, arguments);
		} catch (WSDLException e) {
			e.printStackTrace();
		} catch (FrameworkException e) {
			e.printStackTrace();
		} catch (InvalidOperationNameException e) {
			e.printStackTrace();
		}		
	}
	
	public String requestString(String operation, String[] arguments) {
		String result = "";
		try {
			Item response = this.client.request(operation, arguments);
			result = response.getChild("return").getContent(); 
		} catch (WSDLException e) {
			e.printStackTrace();
		} catch (FrameworkException e) {
			e.printStackTrace();
		} catch (InvalidOperationNameException e) {
			e.printStackTrace();
		} catch (NoSuchFieldException e) {
			e.printStackTrace();
		}
		return result;		
	}

}
