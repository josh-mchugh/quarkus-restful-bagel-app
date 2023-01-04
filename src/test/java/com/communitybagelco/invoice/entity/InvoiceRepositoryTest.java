package com.communitybagelco.invoice.entity;

import javax.inject.Inject;

import org.jooq.DSLContext;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.communitybagelco.order.entity.OrderRepository;

import io.quarkus.test.junit.QuarkusTest;

@QuarkusTest
public class InvoiceRepositoryTest {
    
    @Inject
    DSLContext dsl;

    @Inject
    OrderRepository orderRepository;

    @Test
    public void whenOrderDoesNotExistByIdThenExpectNull() {

        InvoiceRepository repository = new InvoiceRepositoryImpl(dsl);

        Assertions.assertNull(repository.findByOrderId(Integer.MAX_VALUE));
    }

    //TODO: findByOrderId Request object
    //TODO: findByOrderId Optional return type
}
