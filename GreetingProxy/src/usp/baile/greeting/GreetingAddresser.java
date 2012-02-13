package usp.baile.greeting;

import javax.jws.WebService;

@WebService(endpointInterface="usp.baile.greeting.Addresser")
public class GreetingAddresser implements Addresser {

	private String endpoint = "http://localhost:1234/hello";
			
		//{"http://localhost:1234/hello", 
		//"http://localhost:1235/oi", 
		//"http://localhost:1236/ciao"};
	
	@Override
	public String getEndpoint() {
		return endpoint;
	}

	public void setEndpoint(String endpoint){
		this.endpoint = endpoint;
	}
}
