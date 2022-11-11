package com.communitybagelco.order;

import java.util.concurrent.atomic.AtomicInteger;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class OrderServiceImpl implements OrderService {
    
    private AtomicInteger counter = new AtomicInteger();

    @Override
    public Order handleOrder(OrderRequest request) {
        
        Order order = new Order();
        order.setId(counter.incrementAndGet());
        
        return order;
    }
}
