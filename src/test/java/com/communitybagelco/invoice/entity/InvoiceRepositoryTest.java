package com.communitybagelco.invoice.entity;

import java.util.Optional;

import javax.inject.Inject;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.communitybagelco.invoice.entity.model.ImmutableInvoiceRequest;
import com.communitybagelco.invoice.entity.model.InvoiceRequest;
import com.communitybagelco.invoice.model.Invoice;
import com.communitybagelco.order.entity.OrderRepository;

import io.quarkus.test.junit.QuarkusTest;

@QuarkusTest
public class InvoiceRepositoryTest {

    @Inject
    OrderRepository orderRepository;

    @Inject
    InvoiceRepository repository;

    @Test
    public void whenOrderDoesNotExistByIdThenExpectNotPresent() {

        InvoiceRequest request = ImmutableInvoiceRequest.builder()
            .orderId(Integer.MAX_VALUE)
            .build();

        Optional<Invoice> result = repository.findByOrderId(request);

        Assertions.assertFalse(result.isPresent());
    }
}
