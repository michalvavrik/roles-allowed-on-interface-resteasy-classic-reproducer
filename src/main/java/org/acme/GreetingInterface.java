package org.acme;

import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;

@Path("/hello")
public interface GreetingInterface {

    @POST
    @Path("/hi")
    Response sayHi();
}
