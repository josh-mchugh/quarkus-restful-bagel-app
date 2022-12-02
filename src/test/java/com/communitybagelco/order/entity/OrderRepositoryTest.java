package com.communitybagelco.order.entity;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.communitybagelco.order.model.Order;

import io.quarkus.test.junit.QuarkusTest;

@QuarkusTest
@Transactional
public class OrderRepositoryTest {
    
    @Inject
    EntityManager entityManager;

    @Test
    public void whenCreateExpectIdNotNull() {

        OrderRepository repository = new OrderRepositoryImpl(entityManager);

        Order order = repository.create();

        Assertions.assertNotNull(order.getId());
    }

    @Test
    public void whenCreateExpectTimestampNotNull() {

        OrderRepository repository = new OrderRepositoryImpl(entityManager);

        Order order = repository.create();

        Assertions.assertNotNull(order.getTimestamp());
    }
}
