package org.acme;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
class GreetingResourceTest {
    @Test
    void testHelloEndpoint() {
        given()
                .auth().preemptive().basic("admin", "admin")
          .when().post("/hello/hi")
          .then()
             .statusCode(200)
             .body(is("hi"));
        given()
                .auth().preemptive().basic("user", "user")
                .when().post("/hello/hi")
                .then()
                .statusCode(403);
    }

}