package com.communitybagelco.product;

import javax.ws.rs.core.Response;

import org.junit.jupiter.api.Test;

import io.quarkus.test.junit.QuarkusTest;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
public class ProductResourceTest {
    
    @Test
    public void whenGetProductIsValidThenExpectOk() {

        given()
            .when()
                .get("/api/product")
            .then()
                .statusCode(Response.Status.OK.getStatusCode());
    }

    @Test
    public void whenGetProductIsValidThenExpectBodySize() {
        
        given()
            .when()
                .get("/api/product")
            .then()
                .body("size()", is(4));
    }

    @Test
    public void whenGetProductIsValidThenExpectBagels() {
        
        given()
            .when()
                .get("/api/product")
            .then()
                .body("[0].name", is("Plain"))
                .body("[1].name", is("Everything"))
                .body("[2].name", is("Poppy"))
                .body("[3].name", is("Onion"));
    }
}