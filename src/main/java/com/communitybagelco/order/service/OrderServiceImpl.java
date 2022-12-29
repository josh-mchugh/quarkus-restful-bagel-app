package com.communitybagelco.order.service;

import javax.enterprise.context.ApplicationScoped;

import com.communitybagelco.order.entity.OrderRepository;
import com.communitybagelco.order.service.model.OrderRequest;
import com.communitybagelco.order.service.model.OrderResponse;

import lombok.RequiredArgsConstructor;

@ApplicationScoped
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {
    
    private final OrderRepository orderRepository;

    @Override
    public OrderResponse createOrder(OrderRequest request) {
        
        return orderRepository.create(request);
    }
}
