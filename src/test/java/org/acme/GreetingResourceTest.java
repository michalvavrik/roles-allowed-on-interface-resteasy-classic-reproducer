package org.acme;

import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
class GreetingResourceTest {
    @Test
    void testHelloEndpoint() {
        var dto = new GreetingDTO();
        dto.setGreeting("Hello World");
        given()
                .auth().preemptive().basic("admin", "admin")
                .body(dto)
                .contentType(ContentType.JSON)
          .when().post("/hello/hi")
          .then()
             .statusCode(200)
             .body(is("hi"));
        given()
                .auth().preemptive().basic("admin", "admin")
                .body("#@$^^@")
                .contentType(ContentType.JSON)
                .when().post("/hello/hi")
                .then()
                .statusCode(500);
        given()
                .auth().preemptive().basic("user", "user")
                .body("#@$^^@")
                .contentType(ContentType.JSON)
                .when().post("/hello/hi")
                .then()
                .statusCode(403);
        given()
                .auth().preemptive().basic("user", "user")
                .body(dto)
                .contentType(ContentType.JSON)
                .when().post("/hello/hi")
                .then()
                .statusCode(403);
    }

}