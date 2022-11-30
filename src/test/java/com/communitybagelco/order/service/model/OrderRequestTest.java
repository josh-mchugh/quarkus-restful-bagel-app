package com.communitybagelco.order.service.model;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class OrderRequestTest {
    
    @Test
    public void whenOrderRequestHasProductIdsThenExpectProductIds() {

        OrderRequest request = new OrderRequest();
        request.setProductIds(List.of(1, 2, 3));

        Assertions.assertEquals(List.of(1, 2, 3), request.getProductIds());
    }
}
