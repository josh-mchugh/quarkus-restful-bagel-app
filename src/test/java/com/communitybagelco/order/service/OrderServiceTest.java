package com.communitybagelco.order.service;

import java.time.LocalDateTime;
import java.util.List;

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

        Mockito.when(orderRepository.create(Mockito.any(OrderRequest.class))).thenReturn(order);
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

        Order result = service.createOrder(createOrderRequest());

        Assertions.assertEquals(1, result.getId());
    }

    @Test
    public void whenCreateOrderIsValidThenExpectTimeStamp() {

        OrderService service = new OrderServiceImpl(orderRepository);

        Order result = service.createOrder(createOrderRequest());

        Assertions.assertNotNull(result.getTimestamp());
    }

    private OrderRequest createOrderRequest() {

        OrderRequest.Item item = new OrderRequest.Item();
        item.setProductId(1);
        item.setQuantity(1);

        OrderRequest request = new OrderRequest();
        request.setItems(List.of(item));

        return request;
    }
}
