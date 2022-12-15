package com.communitybagelco.order.entity;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.communitybagelco.order.model.Order;
import com.communitybagelco.order.service.model.OrderRequest;
import com.communitybagelco.product.entity.ProductRepository;

import io.quarkus.test.junit.QuarkusTest;
import io.quarkus.test.junit.mockito.InjectMock;

@QuarkusTest
@Transactional
public class OrderRepositoryTest {
    
    @Inject
    EntityManager entityManager;

    @InjectMock
    ProductRepository productRepository;

    @Test
    public void whenCreateExpectIdNotNull() {

        OrderRepository repository = new OrderRepositoryImpl(entityManager, productRepository);

        Order order = repository.create(new OrderRequest());

        Assertions.assertNotNull(order.getId());
    }

    @Test
    public void whenCreateExpectTimestampNotNull() {

        OrderRepository repository = new OrderRepositoryImpl(entityManager, productRepository);

        Order order = repository.create(new OrderRequest());

        Assertions.assertNotNull(order.getTimestamp());
    }

    // TODO: with null order request

    // TODO: with empty order request items

    // TODO: with null order request items

    // TODO: with valid order request items

    // TODO: with null order request item

    // TODO: with null order request item product id

    // TODO: with null order request item quantity 
}
