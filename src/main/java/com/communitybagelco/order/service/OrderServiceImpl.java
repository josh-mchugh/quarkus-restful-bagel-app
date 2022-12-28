package com.communitybagelco.order.service;

import javax.enterprise.context.ApplicationScoped;

import com.communitybagelco.order.entity.OrderRepository;
import com.communitybagelco.order.model.Order;
import com.communitybagelco.order.resource.model.OrderBody;

import lombok.RequiredArgsConstructor;

@ApplicationScoped
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {
    
    private final OrderRepository orderRepository;

    @Override
    public Order createOrder(OrderBody request) {
        
        return orderRepository.create(request);
    }
}
