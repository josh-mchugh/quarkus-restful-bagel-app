package com.communitybagelco.order.resource;

import javax.ws.rs.core.Response;

import org.junit.jupiter.api.Test;

import com.communitybagelco.order.resource.model.OrderBody;

import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.containsString;

import java.util.List;

@QuarkusTest
public class OrderResourceTest {
 
    @Test
    public void whenOrderRequestIsValidThenExpectOk() {

        OrderBody request = new OrderBody();
        request.setItems(List.of(
            new OrderBody.Item(1, 1),
            new OrderBody.Item(2, 1),
            new OrderBody.Item(3, 1)
        ));

        given()
            .when()
                .contentType(ContentType.JSON)
                .body(request)    
                .post("/api/order")
            .then()
                .statusCode(Response.Status.CREATED.getStatusCode());
    }

    @Test
    public void whenOrdeReqeuestHasEmptyItemsThenExpectBadRequest() {

        OrderBody request = new OrderBody();
        request.setItems(List.of());

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
    public void whenOrderHasValidItemsThenExpectBody() {

        OrderBody request = new OrderBody();
        request.setItems(List.of(
            new OrderBody.Item(1, 1),
            new OrderBody.Item(2, 1)
        ));

        given()
            .when()
                .contentType(ContentType.JSON)
                .body(request)
                .post("/api/order")
            .then()
                .header("location", containsString("/api/invoice/"));
    }
}
