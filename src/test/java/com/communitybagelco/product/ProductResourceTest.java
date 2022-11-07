package com.communitybagelco.product;

import javax.ws.rs.core.Response;

import org.junit.jupiter.api.Test;

import io.quarkus.test.junit.QuarkusTest;

import static io.restassured.RestAssured.given;;

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
}
