package org.acme;

import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
class GreetingResourceTest {
    @Test
    void testHiEndpoint() {
        var dto = new GreetingDTO();
        dto.setGreeting("Hello World");
        given()
                .auth().preemptive().basic("admin", "admin")
                .body(dto)
                .contentType(ContentType.JSON)
          .when().post("/hello/hi")
          .then()
                .statusCode(403);
        given()
                .auth().preemptive().basic("admin", "admin")
                .body("#@$^^@")
                .contentType(ContentType.JSON)
                .when().post("/hello/hi")
                .then()
                .statusCode(403);
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

    @Test
    void testHeyEndpoint() {
        var dto = new GreetingDTO();
        dto.setGreeting("Hello World");
        given()
                .auth().preemptive().basic("admin", "admin")
                .body(dto)
                .contentType(ContentType.JSON)
                .when().post("/hello/hey")
                .then()
                .statusCode(200);
        given()
                .auth().preemptive().basic("admin", "admin")
                .body("#@$^^@")
                .contentType(ContentType.JSON)
                .when().post("/hello/hey")
                .then()
                .statusCode(500);
        given()
                .auth().preemptive().basic("user", "user")
                .body("#@$^^@")
                .contentType(ContentType.JSON)
                .when().post("/hello/hey")
                .then()
                .statusCode(403);
        given()
                .auth().preemptive().basic("user", "user")
                .body(dto)
                .contentType(ContentType.JSON)
                .when().post("/hello/hey")
                .then()
                .statusCode(403);
    }

    @Test
    void testHoEndpoint() {
        var dto = new GreetingDTO();
        dto.setGreeting("Hello World");
        given()
                .auth().preemptive().basic("admin", "admin")
                .body(dto)
                .contentType(ContentType.JSON)
                .when().post("/hello/ho")
                .then()
                .statusCode(200);
        given()
                .auth().preemptive().basic("admin", "admin")
                .body("#@$^^@")
                .contentType(ContentType.JSON)
                .when().post("/hello/ho")
                .then()
                .statusCode(500);
        given()
                .auth().preemptive().basic("user", "user")
                .body("#@$^^@")
                .contentType(ContentType.JSON)
                .when().post("/hello/ho")
                .then()
                .statusCode(500);
        given()
                .auth().preemptive().basic("user", "user")
                .body(dto)
                .contentType(ContentType.JSON)
                .when().post("/hello/ho")
                .then()
                .statusCode(200);
    }
}