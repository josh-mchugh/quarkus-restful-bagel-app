package com.communitybagelco.menu;

import javax.ws.rs.core.Response;

import org.junit.jupiter.api.Test;

import io.quarkus.test.junit.QuarkusTest;

import static org.hamcrest.CoreMatchers.is;
import static io.restassured.RestAssured.given;

@QuarkusTest
public class MenuResourceTest {
    
    @Test
    public void whenMenuRequestIsValidThenExpectStatusOk() {

        given()
            .when().get("/api/menu")
            .then()
                .statusCode(Response.Status.OK.getStatusCode());

    }

    @Test
    public void whenMenuRequestIsValidThenExpectBody() {

        given()
            .when().get("/api/menu")
            .then()
                .body("items[0].name", is("Plain"))
                .body("items[0].description", is("General plain bagel"));    
    }
}
