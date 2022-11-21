package com.communitybagelco.order;

import javax.ws.rs.core.Response;

import org.junit.jupiter.api.Test;

import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.given;

import static org.hamcrest.CoreMatchers.is;
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
                .body("products[0].name", is("Plain"))
                .body("products[0].price", is(1.75F))
                //.body("products[1].category.name", is("Bagels"))
                .body("products[1].name", is("Everything"))
                .body("products[1].price", is(1.75F))
                //.body("products[1].category.name", is("Bagels"))
                .body("total", is(3.5F));
    }
}
