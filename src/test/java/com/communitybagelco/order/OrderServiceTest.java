package com.communitybagelco.order;

import javax.inject.Inject;

import org.jooq.DSLContext;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.communitybagelco.product.entity.ProductRepositoryImpl;

public class OrderServiceTest {
    
    @Inject
    DSLContext dsl;

    @Test
    public void whenHandleOrderHasNullRequestThenExpectNoExcpetion() {

        OrderService service = new OrderServiceImpl(new ProductRepositoryImpl(dsl));

        Assertions.assertDoesNotThrow(() -> service.handleOrder((OrderRequest) null));
    }

    @Test
    public void whenHandleOrderHasRequestWithNoProductIdThenExpectNoExceptions() {

        OrderService service = new OrderServiceImpl(new ProductRepositoryImpl(dsl));

        Assertions.assertDoesNotThrow(() -> service.handleOrder(new OrderRequest()));
    }

    @Test
    public void whenHandleOrderIsValidThenExpectId() {

        OrderService service = new OrderServiceImpl(new ProductRepositoryImpl(dsl));

        Order result = service.handleOrder(new OrderRequest());

        Assertions.assertEquals(1, result.getId());
    }

    @Test
    public void whenHandleOrderIsCalledTwiceThenExpectIdValue() {

        OrderService service = new OrderServiceImpl(new ProductRepositoryImpl(dsl));

        service.handleOrder(new OrderRequest());
        Order result = service.handleOrder(new OrderRequest());

        Assertions.assertEquals(2, result.getId());
    }
}
