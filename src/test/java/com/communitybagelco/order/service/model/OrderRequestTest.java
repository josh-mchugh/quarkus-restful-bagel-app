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

    @Test
    public void whenOrderRequestToStringExpectString() {

        String expected = "OrderRequest(productIds=[1])";

        OrderRequest request = new OrderRequest();
        request.setProductIds(List.of(1));

        Assertions.assertEquals(expected, request.toString());
    }

    @Test
    public void whenOrderRequestHashCodeExpectValue() {

        OrderRequest request = new OrderRequest();
        request.setProductIds(List.of(1));

        Assertions.assertEquals(91, request.hashCode());
    }

    @Test
    public void whenOrderRequestEmptyHashCodeExpectValue() {

        Assertions.assertEquals(102, new OrderRequest().hashCode());
    }

    @Test
    public void whenOrderRequestEqualsSameInstanceThenExpectTrue() {

        OrderRequest request1 = new OrderRequest();
        OrderRequest request2 = request1;

        Assertions.assertTrue(request1.equals(request2));
    }

    @Test
    public void whenOrderRequestDifferentTypesThenExpectFalse() {

        OrderRequest request = new OrderRequest();
        Object object = new Object();

        Assertions.assertFalse(request.equals(object));
    }

    @Test
    public void whenOrderRequestIsEqualThenExpectTrue() {

        OrderRequest request1 = new OrderRequest();
        request1.setProductIds(List.of(1));

        OrderRequest request2 = new OrderRequest();
        request2.setProductIds(List.of(1));

        Assertions.assertTrue(request1.equals(request2));
    }

    @Test
    public void whenOrderReuqestIsNotEqualsThenExpectFalse() {

        OrderRequest request1 = new OrderRequest();
        request1.setProductIds(List.of(1));

        OrderRequest request2 = new OrderRequest();
        request2.setProductIds(List.of(2));
        
        Assertions.assertFalse(request1.equals(request2));
    }
}
