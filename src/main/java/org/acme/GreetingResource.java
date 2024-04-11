package org.acme;

import jakarta.annotation.security.PermitAll;
import jakarta.annotation.security.RolesAllowed;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;

@Path("/hello")
public class GreetingResource implements GreetingInterface {

    @Override
    public Response sayHi(GreetingDTO greetingDTO) {
        return Response.ok("hi").build();
    }

    @RolesAllowed("admin")
    @Override
    public Response sayHey(GreetingDTO greetingDTO) {
        return Response.ok("hey").build();
    }

    @PermitAll
    @Override
    public Response sayHo(GreetingDTO greetingDTO) {
        return Response.ok("hu").build();
    }
}
