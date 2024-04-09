package org.acme;

import jakarta.annotation.security.RolesAllowed;
import jakarta.ws.rs.core.Response;

@RolesAllowed("admin")
public class GreetingResource implements GreetingInterface {

    @Override
    public Response sayHi() {
        return Response.ok("hi").build();
    }
}
