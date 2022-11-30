package com.communitybagelco.order.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class OrderTest {
 
    @Test
    public void whenOrderHasIdThenExpectId() {
        
        Order order = new Order(1);

        Assertions.assertEquals(1, order.getId());
    }

    @Test
    public void whenOrderToStringThenExpectString() {

        String expected = "Order(id=1)";

        Assertions.assertEquals(expected, new Order(1).toString());
    }

    @Test
    public void whenOrderHashCodeThenExpectValue() {

        Assertions.assertEquals(60, new Order(1).hashCode());
    }

    @Test
    public void whenOrderIsEmptylIdThenExpectHashValue() {

        Assertions.assertEquals(102, new Order(null).hashCode());
    }

    @Test
    public void whenOrderEqualsSameInstanceThenExpectTrue() {

        Order order1 = new Order(1);
        Order order2 = order1;

        Assertions.assertTrue(order1.equals(order2));
    }

    @Test
    public void whenOrderEqualsNotSameTypeThenExpectFalse() {

        Order order = new Order(1);
        Object object = new Object();

        Assertions.assertFalse(order.equals(object));
    }

    @Test
    public void whenOrderEqualsIsEqualThenExpectTrue() {

        Order order1 = new Order(1);
        Order order2 = new Order(1);

        Assertions.assertTrue(order1.equals(order2));
    }

    @Test
    public void whenOrderEqualsIsNotEqualThenExpectFalse() {

        Order order1 = new Order(1);
        Order order2 = new Order(2);

        Assertions.assertFalse(order1.equals(order2));
    }
}
