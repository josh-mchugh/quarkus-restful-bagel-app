package com.communitybagelco.order;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class OrderTest {
 
    @Test
    public void whenOrderHasIdThenExpectId() {
        
        Order order = new Order();
        order.setId(1);

        Assertions.assertEquals(1, order.getId());
    }
}
