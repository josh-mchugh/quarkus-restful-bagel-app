package com.communitybagelco.order;

import javax.ws.rs.core.Response;

import org.junit.jupiter.api.Test;

import com.communitybagelco.order.service.model.OrderRequest;

import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.Matchers.greaterThan;

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
    public void whenOrderRequestHasNullProductIdsThenExpectBadRequest() {

        given()
            .when()
                .contentType(ContentType.JSON)
                .body(new OrderRequest())
                .post("/api/order")
            .then()
                .statusCode(Response.Status.BAD_REQUEST.getStatusCode());
    }

    @Test
    public void whenOrdeReqeuestHasEmptyProductIdsThenExpectBadRequest() {

        OrderRequest request = new OrderRequest();
        request.setProductIds(List.of());

        given()
            .when()
                .contentType(ContentType.JSON)
                .body(request)
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
    public void whenOrderHasValidProductsThenExpectBody() {

        OrderRequest request = new OrderRequest();
        request.setProductIds(List.of(1, 2));

        given()
            .when()
                .contentType(ContentType.JSON)
                .body(request)
                .post("/api/order")
            .then()
                .body("id", notNullValue())
                .body("id", greaterThan(0))
                .body("timestamp", notNullValue());
    }
}
