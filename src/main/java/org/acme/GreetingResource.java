package org.acme;

import jakarta.ws.rs.core.Response;

public class GreetingResource implements GreetingInterface {

    @Override
    public Response sayHi(GreetingDTO greetingDTO) {
        return Response.ok("hi").build();
    }
}
