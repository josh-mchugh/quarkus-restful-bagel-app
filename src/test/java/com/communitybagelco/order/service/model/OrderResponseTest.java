package com.communitybagelco.order.service.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import nl.jqno.equalsverifier.EqualsVerifier;

public class OrderResponseTest {

    @Test
    public void whenResponseHasOrderIdThenExpectOrderId() {

        OrderResponse response = ImmutableOrderResponse.builder()
            .orderId(1)
            .build();

        Assertions.assertEquals(1, response.orderId());
    }

    @Test
    public void whenResponseBuilderOrderIdNullThenExpectException() {

        ImmutableOrderResponse.Builder builder = ImmutableOrderResponse.builder();

        Assertions.assertThrows(NullPointerException.class, () -> builder.orderId((Integer) null));
    }

    @Test
    public void whenResponseBuilderBuildEmptyThenExpectException() {

        ImmutableOrderResponse.Builder builder = ImmutableOrderResponse.builder();

        Assertions.assertThrows(IllegalStateException.class, () -> builder.build());
    }

    @Test
    public void whenResponseToStringThenExpectValue() {

        String expected = "OrderResponse{orderId=1}";

        OrderResponse response = createOrderResponse();

        Assertions.assertEquals(expected, response.toString());
    }

    @Test
    public void whenResponseEqualsIsSameInstanceThenExpectTrue() {

        OrderResponse response1 = createOrderResponse();
        OrderResponse response2 = response1;

        Assertions.assertTrue(response1.equals(response2));
    }

    @Test
    public void whenResponseEqualsIsDifferentTypeThenExpectFalse() {

        OrderResponse response = createOrderResponse();
        Object object = new Object();

        Assertions.assertFalse(response.equals(object));
    }

    @Test
    public void whenResponseEqualsIsEqualThenExpectTrue() {

        OrderResponse response1 = createOrderResponse();
        OrderResponse response2 = createOrderResponse();

        Assertions.assertTrue(response1.equals(response2));
    }

    @Test
    public void whenResponseEqualsIsNotEqualThenExpectFalse() {

        OrderResponse response1 = createOrderResponse(1);
        OrderResponse response2 = createOrderResponse(2);

        Assertions.assertFalse(response1.equals(response2));
    }

    @Test
    public void orderResponseEqualsContract() {

        EqualsVerifier.simple()
            .forClass(ImmutableOrderResponse.class)
            .withNonnullFields("orderId")
            .withResetCaches()
            .verify();
    }

    @Test
    public void whenResponseHashcodeThenExpectValue() {

        OrderResponse response = createOrderResponse();

        Assertions.assertEquals(177574, response.hashCode());
    }

    private OrderResponse createOrderResponse() {

        return createOrderResponse(1);
    }

    private OrderResponse createOrderResponse(Integer orderId) {

        return ImmutableOrderResponse.builder()
            .orderId(orderId)
            .build();
    }
}
