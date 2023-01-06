package com.communitybagelco.invoice.entity;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import javax.inject.Inject;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.communitybagelco.invoice.entity.model.ImmutableInvoiceRequest;
import com.communitybagelco.invoice.entity.model.InvoiceRequest;
import com.communitybagelco.invoice.model.Invoice;
import com.communitybagelco.order.entity.OrderRepository;
import com.communitybagelco.order.service.model.ImmutableItem;
import com.communitybagelco.order.service.model.ImmutableOrderRequest;
import com.communitybagelco.order.service.model.OrderRequest;
import com.communitybagelco.order.service.model.OrderResponse;

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

    @Test
    public void whenOrderExistsByIdThenExpectOrderId() {

        Integer orderId = createOrderId();

        InvoiceRequest request = ImmutableInvoiceRequest.builder()
            .orderId(orderId)
            .build();

        Optional<Invoice> result = repository.findByOrderId(request);

        Assertions.assertEquals(orderId, result.get().orderId());
    }

    @Test
    public void whenOrderExistsThenExpectTimestampNotNull() {

        Invoice invoice = createInvoice();

        Assertions.assertNotNull(invoice.timestamp());
    }

    @Test
    public void whenOrderExistsThenExpectTotal() {

        Invoice invoice = createInvoice();

        Assertions.assertEquals(new BigDecimal("5.25"), invoice.total());
    }

    @Test
    public void whenOrderExistsThenExpectItemsNotNull() {

        Invoice invoice = createInvoice();

        Assertions.assertNotNull(invoice.items());
    }

    @Test
    public void whenOrderDoesNotHaveItemsThenExpectEmptyItems() {

        OrderRequest orderRequest = ImmutableOrderRequest.builder().build();
        OrderResponse orderResponse = orderRepository.create(orderRequest);

        InvoiceRequest request = ImmutableInvoiceRequest.builder()
            .orderId(orderResponse.orderId())
            .build();

        Optional<Invoice> invoice = repository.findByOrderId(request);

        Assertions.assertEquals(0, invoice.get().items().size());
    }

    @Test
    public void whenOrderExistsThenExpectItemsSize() {

        Invoice invoice = createInvoice();

        Assertions.assertEquals(2, invoice.items().size());
    }

    @Test
    public void whenOrderExiststhenExpectItems() {

        Invoice invoice = createInvoice();

        Assertions.assertEquals(expectedItems(), invoice.items());
    }

    private List<Invoice.Item> expectedItems() {

        Invoice.Item plainBagel = com.communitybagelco.invoice.model.ImmutableItem.builder()
            .productId(1)
            .productName("Plain")
            .quantity(1)
            .total(new BigDecimal("1.75"))
            .build();

        Invoice.Item everythingBagel = com.communitybagelco.invoice.model.ImmutableItem.builder()
            .productId(2)
            .productName("Everything")
            .quantity(2)
            .total(new BigDecimal("3.5"))
            .build();

        return List.of(plainBagel, everythingBagel);
    }

    private Invoice createInvoice() {

        InvoiceRequest request = ImmutableInvoiceRequest.builder()
            .orderId(createOrderId())
            .build();

        return repository.findByOrderId(request).get();
    }

    private Integer createOrderId() {

        OrderRequest orderRequest = createOrderRequest();
        
        return orderRepository.create(orderRequest).orderId();
    }

    private OrderRequest createOrderRequest() {

        OrderRequest.Item plainBagelItem = ImmutableItem.builder()
            .productId(1)
            .quantity(1)
            .build();

        OrderRequest.Item everythingBagelItem = ImmutableItem.builder()
            .productId(2)
            .quantity(2)
            .build();

        return ImmutableOrderRequest.builder()
            .addItems(plainBagelItem, everythingBagelItem)
            .build();
    }
}
