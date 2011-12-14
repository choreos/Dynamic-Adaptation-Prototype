package usp.baile.greeting;

import javax.jws.WebService;

@WebService(endpointInterface="usp.baile.greeting.Greeting")
public class GreetingProxy implements Greeting {

	@Override
	public String greet(String name) {
		return null;
	}

}
