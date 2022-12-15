package com.communitybagelco.order.service;

import javax.enterprise.context.ApplicationScoped;

import com.communitybagelco.order.entity.OrderRepository;
import com.communitybagelco.order.model.Order;
import com.communitybagelco.order.service.model.OrderRequest;

import lombok.RequiredArgsConstructor;

@ApplicationScoped
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {
    
    private final OrderRepository orderRepository;

    @Override
    public Order createOrder(OrderRequest request) {
        
        return orderRepository.create(request);
    }
}
