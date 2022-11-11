package com.communitybagelco.order;

import javax.ws.rs.core.Response;

import org.hamcrest.CoreMatchers;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.given;

import java.util.List;

@QuarkusTest
public class OrderResourceTest {
 
    @Test
    public void whenOrderRequestIsValidThenExpectOk() {

        OrderRequest request = new OrderRequest();
        request.setProductIds(List.of(1, 2, 3));

        given()
            .when()
                .contentType(ContentType.JSON)
                .body(request)    
                .post("/api/order")
            .then()
                .statusCode(Response.Status.OK.getStatusCode());
    }

    @Test
    public void whenOrderRequestHasEmptyProductIdsThenExpectBadRequest() {

        given()
            .when()
                .contentType(ContentType.JSON)
                .body(new OrderRequest())
                .post("/api/order")
            .then()
                .statusCode(Response.Status.BAD_REQUEST.getStatusCode());
    }

    @Test
    public void whenOrderRequestHasNullRequestThenExpectBadRequest() {

        given()
            .when()
                .contentType(ContentType.JSON)
                .post("/api/order")
            .then()
                .statusCode(Response.Status.BAD_REQUEST.getStatusCode());
    }

    @Test
    public void whenOrderHasValidProductsThenExpectId() {

        OrderRequest request = new OrderRequest();
        request.setProductIds(List.of(1));

        given()
            .when()
                .contentType(ContentType.JSON)
                .body(request)
                .post("/api/order")
            .then()
                .body("id", CoreMatchers.notNullValue())
                .body("id", Matchers.greaterThan(0));
            
    }
}
