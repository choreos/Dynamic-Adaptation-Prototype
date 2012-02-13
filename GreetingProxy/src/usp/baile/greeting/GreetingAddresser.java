package usp.baile.greeting;

import javax.jws.WebService;

@WebService(endpointInterface="usp.baile.greeting.Addresser")
public class GreetingAddresser implements Addresser {

	private int count = 0;
	private String[] endpoints = {"http://localhost:1234/hello", 
										"http://localhost:1235/oi", 
										"http://localhost:1236/ciao"};
	private String fixedEndpoint;
	
	
	@Override
	public String getEndpoint() {
		
		if (fixedEndpoint != null){
			return fixedEndpoint;
		}
		
		//Round robin
		else{
			count++;
			String res = endpoints[count%3];
			System.out.println(res);
			return res;
		}
	}
	
	public void setEndpoint(String endpoint){
		this.fixedEndpoint = endpoint;
	}
}
