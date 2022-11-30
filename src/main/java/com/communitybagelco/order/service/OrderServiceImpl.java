package com.communitybagelco.order.service;

import java.util.concurrent.atomic.AtomicInteger;

import javax.enterprise.context.ApplicationScoped;

import com.communitybagelco.order.model.Order;
import com.communitybagelco.order.service.model.OrderRequest;
import com.communitybagelco.product.entity.ProductRepository;

import lombok.RequiredArgsConstructor;

@ApplicationScoped
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {
    
    private final ProductRepository productRepository;

    private AtomicInteger counter = new AtomicInteger();

    @Override
    public Order handleOrder(OrderRequest request) {
        
        return new Order(counter.incrementAndGet());
    }
}
