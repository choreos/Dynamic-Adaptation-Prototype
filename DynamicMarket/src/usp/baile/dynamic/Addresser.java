package usp.baile.dynamic;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public interface Addresser {

	@WebMethod
	String getEndpoint(String role);
}
