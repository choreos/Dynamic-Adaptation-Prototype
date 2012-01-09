package usp.baile.dynamic.proxy;

import java.io.IOException;

import javax.jws.WebService;

import org.apache.xmlbeans.XmlException;

import eu.choreos.vv.clientgenerator.Item;
import eu.choreos.vv.clientgenerator.WSClient;
import eu.choreos.vv.exceptions.FrameworkException;
import eu.choreos.vv.exceptions.InvalidOperationNameException;
import eu.choreos.vv.exceptions.WSDLException;

import usp.baile.dynamic.Supermarket;

@WebService(endpointInterface="usp.baile.dynamic.Supermarket")
public class SupermarketProxy implements Supermarket {

	private static String ADDRESSER_ENDPOINT = "http://localhost:1237/addresser?wsdl";

	@Override
	public void purchase(String item, String client) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String findItem(String item) {

		String OPERATION = "findItem"; 

		WSClient addresser = null;
		try {
			addresser = new WSClient(ADDRESSER_ENDPOINT);
		} catch (WSDLException e) {
			e.printStackTrace();
		} catch (XmlException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (FrameworkException e) {
			e.printStackTrace();
		}

		
		Item response;
		String partnerLinkEndpoint = null;
		try {
			response = addresser.request("getEndpoint", "supermarket");
			partnerLinkEndpoint = response.getChild("return").getContent();
			System.out.println("DYNAMIC ENDPOINT: " + partnerLinkEndpoint + "?wsdl");
		} catch (InvalidOperationNameException e) {
			e.printStackTrace();
		} catch (FrameworkException e) {
			e.printStackTrace();
		} catch (NoSuchFieldException e) {
			e.printStackTrace();
		}
		
		String resultXml = "";
		try {
			WSClient service = new WSClient(partnerLinkEndpoint + "?wsdl");
			response = service.request(OPERATION, item);
			// resultXml = response.getXML(); // TODO
		} catch (WSDLException e) {
			e.printStackTrace();
		} catch (XmlException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (FrameworkException e) {
			e.printStackTrace();
		} catch (InvalidOperationNameException e) {
			e.printStackTrace();
		}

		// TODO aqui vai retornar XML dentro de um xml pra string
		// teria q ser direto
		return resultXml;
	}

}
