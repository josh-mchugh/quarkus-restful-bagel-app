package com.communitybagelco.order.entity;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import javax.transaction.Transactional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.communitybagelco.order.service.model.ImmutableItem;
import com.communitybagelco.order.service.model.ImmutableOrderRequest;
import com.communitybagelco.order.service.model.OrderRequest;
import com.communitybagelco.order.service.model.OrderResponse;
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
    public void whenCreateExpectOrderIdNotNull() {

        OrderRepository repository = new OrderRepositoryImpl(entityManager, productRepository);

        OrderResponse response = repository.create(ImmutableOrderRequest.builder().build());

        Assertions.assertNotNull(response.orderId());
    }

    @Test
    public void whenCreateParamIsNullThenExpectException() {
        
        OrderRepository repository = new OrderRepositoryImpl(entityManager, productRepository);

        Assertions.assertThrows(NullPointerException.class, () -> repository.create((OrderRequest) null));
    }

    @Test
    public void whenCreateParamHasValidItemsThenExpectOrderId() {

        OrderRepository repository = new OrderRepositoryImpl(entityManager, productRepository);

        OrderRequest.Item item = ImmutableItem.builder()
            .productId(1)
            .quantity(1)
            .build();

        OrderRequest request = ImmutableOrderRequest.builder()
            .addItems(item)
            .build();

        Assertions.assertNotNull(repository.create(request).orderId());
    }

    @Test
    public void whenCreateParamHasEmptyItemsThenExpectOrderId() {

        OrderRepository repository = new OrderRepositoryImpl(entityManager, productRepository);

        Assertions.assertNotNull(repository.create(ImmutableOrderRequest.builder().build()).orderId());
    }

    @Test
    public void whenCreateParamHasNullItemsThenExpectException() {

        OrderRepository repository = new OrderRepositoryImpl(entityManager, productRepository);

        OrderRequest request = ImmutableOrderRequest.builder()
            .items(null)
            .build();

        Assertions.assertThrows(NullPointerException.class, () -> repository.create(request));
    }

    @Test
    public void whenCreateParamHasNullItemThenExpectException() {

        OrderRepository repository = new OrderRepositoryImpl(entityManager, productRepository);

        OrderRequest request = ImmutableOrderRequest.builder()
            .addItems((ImmutableItem) null)
            .build();

        Assertions.assertThrows(NullPointerException.class, () -> repository.create(request));
    }

    @Test
    public void whenCreateParamHasItemWithNullProductIdThenExpectNoException() {

        OrderRepository repository = new OrderRepositoryImpl(entityManager, productRepository);
        
        OrderRequest.Item item = ImmutableItem.builder()
            .productId(null)
            .quantity(1)
            .build();

        OrderRequest request = ImmutableOrderRequest.builder()
            .addItems(item)
            .build();

        Assertions.assertDoesNotThrow(() -> repository.create(request));
    }

    @Test
    public void whenCreateParamHasItemNullQuantityThenExpectId() {

        OrderRepository repository = new OrderRepositoryImpl(entityManager, productRepository);

        OrderRequest.Item item = ImmutableItem.builder()
            .productId(1)
            .quantity(null)
            .build();

        OrderRequest request = ImmutableOrderRequest.builder()
            .addItems(item)
            .build();

        Assertions.assertThrows(PersistenceException.class, () -> repository.create(request));
    }
}
