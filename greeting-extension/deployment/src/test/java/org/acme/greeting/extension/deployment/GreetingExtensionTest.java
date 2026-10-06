package org.acme.greeting.extension.deployment;

import io.quarkus.test.QuarkusExtensionTest;
import io.restassured.RestAssured;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.RegisterExtension;

import static org.hamcrest.Matchers.containsString;

public class GreetingExtensionTest {

    @RegisterExtension
    static final QuarkusExtensionTest config = new QuarkusExtensionTest()
            .withEmptyApplication();

    @Test
    void testGreeting() {
        RestAssured.when().get("/greeting")
                .then()
                .statusCode(200)
                .body(containsString("Hello"));
    }
}
