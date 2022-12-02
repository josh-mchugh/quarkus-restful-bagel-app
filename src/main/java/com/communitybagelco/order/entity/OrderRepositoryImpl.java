package com.communitybagelco.order.entity;

import java.time.LocalDateTime;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import com.communitybagelco.order.model.Order;

import lombok.AllArgsConstructor;

@Transactional
@ApplicationScoped
@AllArgsConstructor
public class OrderRepositoryImpl implements OrderRepository {
    
    private final EntityManager entityManager;

    @Override
    public Order create() {
        
        OrderEntity entity = new OrderEntity();
        entity.setTimestamp(LocalDateTime.now());
        
        entityManager.persist(entity);

        return Order.builder()
            .id(entity.getId())
            .timestamp(entity.getTimestamp())
            .build();
    }
}
