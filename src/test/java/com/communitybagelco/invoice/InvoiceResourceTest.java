package com.communitybagelco.invoice;

import javax.inject.Inject;
import javax.ws.rs.core.Response;

import org.junit.jupiter.api.Test;

import com.communitybagelco.order.entity.OrderRepository;
import com.communitybagelco.order.service.model.ImmutableItem;
import com.communitybagelco.order.service.model.ImmutableOrderRequest;
import com.communitybagelco.order.service.model.OrderRequest;
import com.communitybagelco.order.service.model.OrderResponse;

import io.quarkus.test.junit.QuarkusTest;
import io.restassured.RestAssured;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;;

@QuarkusTest
public class InvoiceResourceTest {
    
    @Inject
    OrderRepository orderRepository;

    @Test
    public void whenGetInvoiceWithInvalidOrderIdThenExpectNotFound() {

        RestAssured.given()
            .get(String.format("/api/invoice/%s", Integer.MAX_VALUE))
            .then()
                .statusCode(Response.Status.NOT_FOUND.getStatusCode());
    }

    @Test
    public void whenGetInvoiceWithValidOrderIdThenExpectResult() {

        OrderRequest.Item plainBagel = ImmutableItem.builder()
            .productId(1)
            .quantity(3)
            .build();

        OrderRequest.Item poppyBagel = ImmutableItem.builder()
            .productId(3)
            .quantity(1)
            .build();

        OrderRequest orderRequest = ImmutableOrderRequest.builder()
            .addItems(plainBagel, poppyBagel)
            .build();
        OrderResponse orderResponse = orderRepository.create(orderRequest);

        RestAssured.given()
            .when()
                .get(String.format("/api/invoice/%s", orderResponse.orderId()))
            .then()
                .statusCode(Response.Status.OK.getStatusCode())
                .body("orderId", is(orderResponse.orderId()))
                .body("timestamp", notNullValue())
                .body("total", is(7.0F))
                .body("items[0].productId", is(1))
                .body("items[0].productName", is("Plain"))
                .body("items[0].quantity", is(3))
                .body("items[0].total", is(5.25F))
                .body("items[1].productId", is(3))
                .body("items[1].productName", is("Poppy"))
                .body("items[1].quantity", is(1))
                .body("items[1].total", is(1.75F));
        
    }
}
