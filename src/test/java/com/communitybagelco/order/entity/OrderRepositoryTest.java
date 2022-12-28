package com.communitybagelco.order.entity;

import java.util.Collections;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import javax.transaction.Transactional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.communitybagelco.order.model.Order;
import com.communitybagelco.order.resource.model.OrderBody;
import com.communitybagelco.product.ProductRepository;

import io.quarkus.test.junit.QuarkusTest;

@QuarkusTest
@Transactional
public class OrderRepositoryTest {
    
    @Inject
    EntityManager entityManager;

    @Inject
    ProductRepository productRepository;

    @Test
    public void whenCreateExpectIdNotNull() {

        OrderRepository repository = new OrderRepositoryImpl(entityManager, productRepository);

        Order order = repository.create(new OrderBody());

        Assertions.assertNotNull(order.getId());
    }

    @Test
    public void whenCreateExpectTimestampNotNull() {

        OrderRepository repository = new OrderRepositoryImpl(entityManager, productRepository);

        Order order = repository.create(new OrderBody());

        Assertions.assertNotNull(order.getTimestamp());
    }

    @Test
    public void whenCreateParamIsNullThenExpectException() {
        
        OrderRepository repository = new OrderRepositoryImpl(entityManager, productRepository);

        Assertions.assertThrows(NullPointerException.class, () -> repository.create((OrderBody) null));
    }

    @Test
    public void whenCreateParamHasValidItemsThenExpectId() {

        OrderRepository repository = new OrderRepositoryImpl(entityManager, productRepository);

        OrderBody.Item item = new OrderBody.Item();
        item.setProductId(1);
        item.setQuantity(1);

        OrderBody request = new OrderBody();
        request.setItems(List.of(item));

        Assertions.assertNotNull(repository.create(request).getId());
    }

    @Test
    public void whenCreateParamHasEmptyItemsThenExpectId() {

        OrderRepository repository = new OrderRepositoryImpl(entityManager, productRepository);

        Assertions.assertNotNull(repository.create(new OrderBody()).getId());
    }

    @Test
    public void whenCreateParamHasNullItemsThenExpectException() {

        OrderRepository repository = new OrderRepositoryImpl(entityManager, productRepository);

        OrderBody request = new OrderBody();
        request.setItems(null);

        Assertions.assertThrows(NullPointerException.class, () -> repository.create(request));
    }

    @Test
    public void whenCreateParamHasNullItemThenExpectException() {

        OrderRepository repository = new OrderRepositoryImpl(entityManager, productRepository);

        OrderBody request = new OrderBody();
        request.setItems(Collections.singletonList(null));

        Assertions.assertThrows(NullPointerException.class, () -> repository.create(request));
    }

    @Test
    public void whenCreateParamHasItemWithNullProductIdThenExpectNoException() {

        OrderRepository repository = new OrderRepositoryImpl(entityManager, productRepository);

        OrderBody.Item item = new OrderBody.Item();
        item.setProductId(null);
        item.setQuantity(1);

        OrderBody request = new OrderBody();
        request.setItems(List.of(item));

        Assertions.assertDoesNotThrow(() -> repository.create(request));
    }

    @Test
    public void whenCreateParamHasItemNullQuantityThenExpectId() {

        OrderRepository repository = new OrderRepositoryImpl(entityManager, productRepository);

        OrderBody.Item item = new OrderBody.Item();
        item.setProductId(1);
        item.setQuantity(null);

        OrderBody request = new OrderBody();
        request.setItems(List.of(item));

        Assertions.assertThrows(PersistenceException.class, () -> repository.create(request));
    }
}
