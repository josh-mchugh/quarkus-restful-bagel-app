package com.communitybagelco.menu;

import javax.ws.rs.core.Response;

import org.junit.jupiter.api.Test;

import io.quarkus.test.junit.QuarkusTest;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
public class MenuItemResourceTest {
    
    @Test
    public void whenGetMenuThenExpectOk() {

        given()
            .when()
                .get("/api/menu")
            .then()
                .statusCode(Response.Status.OK.getStatusCode());
    }

    @Test
    public void whenGetMenuThenExpectBody() {

        given()
            .when()
                .get("/api/menu")
            .then()
                .body("[0].productId", is(1))
                .body("[0].name", is("Plain"))
                .body("[0].price", is(1.75F))
                .body("[1].productId", is(2))
                .body("[1].name", is("Everything"))
                .body("[1].price", is(1.75F))
                .body("[2].productId", is(3))
                .body("[2].name", is("Poppy"))
                .body("[2].price", is(1.75F))
                .body("[3].productId", is(4))
                .body("[3].name", is("Onion"))
                .body("[3].price", is(1.75F));
    }
}
