package org.acme;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import javax.inject.Inject;
import org.eclipse.microprofile.config.Config;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
public class GreetingResourceTest {
 @Inject
    Config config;
    @Inject
    @ConfigProperty(name = "mongodb.uri")
    String mongodburi;
    @Test
    public void testHelloEndpoint() {
        given()
          .when().get("/hello")
          .then()
             .statusCode(200)
             .body(is("Mongodburi= " + mongodburi));
    }
}