package com.communitybagelco.order.service;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.communitybagelco.order.entity.OrderRepository;
import com.communitybagelco.order.model.Order;
import com.communitybagelco.order.service.model.OrderRequest;

public class OrderServiceTest {

    private OrderRepository orderRepository;

    @BeforeEach
    public void setup() {

        orderRepository = Mockito.mock(OrderRepository.class);

        Order order = Order.builder()
            .id(1)
            .timestamp(LocalDateTime.now())
            .build();

        Mockito.when(orderRepository.create()).thenReturn(order);
    }

    @Test
    public void whenCreateOrderHasNullRequestThenExpectNoExcpetion() {

        OrderService service = new OrderServiceImpl(orderRepository);

        Assertions.assertDoesNotThrow(() -> service.createOrder((OrderRequest) null));
    }

    @Test
    public void whenCreateOrderHasRequestWithNoProductIdThenExpectNoExceptions() {

        OrderService service = new OrderServiceImpl(orderRepository);

        Assertions.assertDoesNotThrow(() -> service.createOrder(new OrderRequest()));
    }

    @Test
    public void whenCreateOrderIsValidThenExpectId() {

        OrderService service = new OrderServiceImpl(orderRepository);

        Order result = service.createOrder(new OrderRequest());

        Assertions.assertEquals(1, result.getId());
    }

    @Test
    public void whenCreateOrderIsValidThenExpectTimeStamp() {

        OrderService service = new OrderServiceImpl(orderRepository);

        Order result = service.createOrder(new OrderRequest());

        Assertions.assertNotNull(result.getTimestamp());
    }
}
