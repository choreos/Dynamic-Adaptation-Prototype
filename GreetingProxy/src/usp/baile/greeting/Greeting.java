package usp.baile.greeting;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public interface Greeting {

	@WebMethod
	public String greet(String name);
}
