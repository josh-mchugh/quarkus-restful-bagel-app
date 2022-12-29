package com.communitybagelco.order.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.communitybagelco.order.entity.OrderRepository;
import com.communitybagelco.order.service.model.ImmutableItem;
import com.communitybagelco.order.service.model.ImmutableOrderRequest;
import com.communitybagelco.order.service.model.ImmutableOrderResponse;
import com.communitybagelco.order.service.model.OrderRequest;
import com.communitybagelco.order.service.model.OrderResponse;

public class OrderServiceTest {

    private OrderRepository orderRepository;

    @BeforeEach
    public void setup() {

        orderRepository = Mockito.mock(OrderRepository.class);

        OrderResponse response = ImmutableOrderResponse.builder()
            .orderId(1)
            .build();

        Mockito.when(orderRepository.create(Mockito.any(OrderRequest.class))).thenReturn(response);
    }

    @Test
    public void whenCreateOrderHasNullRequestThenExpectNoExcpetion() {

        OrderService service = new OrderServiceImpl(orderRepository);

        Assertions.assertDoesNotThrow(() -> service.createOrder((OrderRequest) null));
    }

    @Test
    public void whenCreateOrderHasRequestWithNoProductIdThenExpectNoExceptions() {

        OrderService service = new OrderServiceImpl(orderRepository);

        Assertions.assertDoesNotThrow(() -> service.createOrder(ImmutableOrderRequest.builder().build()));
    }

    @Test
    public void whenCreateOrderIsValidThenExpectId() {

        OrderService service = new OrderServiceImpl(orderRepository);

        OrderResponse response = service.createOrder(createOrderRequest());

        Assertions.assertEquals(1, response.orderId());
    }

    private OrderRequest createOrderRequest() {

        OrderRequest.Item item = ImmutableItem.builder()
            .productId(1)
            .quantity(1)
            .build();

        return ImmutableOrderRequest.builder()
            .addItems(item)
            .build();
    }
}
