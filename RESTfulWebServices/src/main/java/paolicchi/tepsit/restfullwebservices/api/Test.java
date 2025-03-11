package paolicchi.tepsit.restfullwebservices.api;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;

@Path("/test")
public class Test {
	@GET
	@Path("{name}")
	public String test(@PathParam("name") String name) {
		return "Ciao " + name.toUpperCase();
	}
}