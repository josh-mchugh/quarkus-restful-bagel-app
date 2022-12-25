package com.communitybagelco.order.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import nl.jqno.equalsverifier.EqualsVerifier;

public class OrderTest {
 
    @Test
    public void whenOrderHasIdThenExpectId() {
        
        Order order = Order.builder()
            .id(1)
            .build();

        Assertions.assertEquals(1, order.getId());
    }

    @Test
    public void whenOrderHasTimeStampExpectTimestamp() {

        LocalDateTime now = LocalDateTime.now();

        Order order = Order.builder()
            .timestamp(now)
            .build();

        Assertions.assertEquals(now, order.getTimestamp());
    }

    @Test
    public void whenOrderToStringThenExpectString() {

        String expected = "Order(id=1, timestamp=2011-12-03T10:15:30)";

        Order order = createOrder();

        Assertions.assertEquals(expected, order.toString());
    }

    @Test
    public void whenOrderBuildToStringThenExpectString() {

        String expected = "Order.Builder(id=1, timestamp=2011-12-03T10:15:30)";

        Order.Builder builder = Order.builder()
            .id(1)
            .timestamp(createTimestamp());

        Assertions.assertEquals(expected, builder.toString());
    }

    @Test
    public void whenOrderHashCodeThenExpectValue() {

        Order order = createOrder();

        Assertions.assertEquals(1874263145, order.hashCode());
    }

    @Test
    public void whenOrderIsEmptyThenExpectHashValue() {

        Assertions.assertEquals(6061, Order.builder().build().hashCode());
    }

    @Test
    public void whenOrderEqualsSameInstanceThenExpectTrue() {

        Order order1 = createOrder();
        Order order2 = order1;

        Assertions.assertTrue(order1.equals(order2));
    }

    @Test
    public void whenOrderEqualsNotSameTypeThenExpectFalse() {

        Order order = createOrder();
        Object object = new Object();

        Assertions.assertFalse(order.equals(object));
    }

    @Test
    public void whenOrderEqualsIsEqualThenExpectTrue() {

        Order order1 = createOrder();
        Order order2 = createOrder();

        Assertions.assertTrue(order1.equals(order2));
    }

    @Test
    public void whenOrderEqualsIsNotEqualThenExpectFalse() {

        Order order1 = createOrder(1);
        Order order2 = createOrder(2);

        Assertions.assertFalse(order1.equals(order2));
    }

    @Test
    public void orderEqualsContract() {

        EqualsVerifier.simple().forClass(Order.class)
            .verify();
    }

    private Order createOrder(){

        return createOrder(1);
    }

    private Order createOrder(Integer id) {

        return Order.builder()
            .id(id)
            .timestamp(createTimestamp())
            .build();
    }

    private LocalDateTime createTimestamp() {

        return LocalDateTime.parse("2011-12-03T10:15:30", DateTimeFormatter.ISO_LOCAL_DATE_TIME);
    }
}
