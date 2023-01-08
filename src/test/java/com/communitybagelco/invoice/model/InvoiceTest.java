package com.communitybagelco.invoice.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class InvoiceTest {

    @Test
    public void whenInvoiceHasOrderIdThenExpectOrderId() {

        Invoice invoice = ImmutableInvoice.builder()
            .orderId(1)
            .timestamp(LocalDateTime.now())
            .total(BigDecimal.ZERO)
            .build();

        Assertions.assertEquals(1, invoice.orderId());
    }

    @Test
    public void whenInvoiceBuilderDoesNotHaveOrderIdThenExpectException() {

        ImmutableInvoice.Builder builder = ImmutableInvoice.builder()
            .timestamp(LocalDateTime.now())
            .total(BigDecimal.ZERO);

        Assertions.assertThrows(IllegalStateException.class, () -> builder.build());
    }

    @Test
    public void whenInvoiceHasTimeStampThenExpectTimeStamp() {
        
        LocalDateTime now = LocalDateTime.now();

        Invoice invoice = ImmutableInvoice.builder()
            .orderId(1)
            .timestamp(now)
            .total(BigDecimal.ZERO)
            .build();

        Assertions.assertEquals(now, invoice.timestamp());
    } 

    @Test
    public void whenInvoiceBuilderDoesnotHaveTimeStampThenExpectException() {

        ImmutableInvoice.Builder builder = ImmutableInvoice.builder()
            .orderId(1)
            .total(BigDecimal.ZERO);

        Assertions.assertThrows(IllegalStateException.class, () -> builder.build());
    }

    @Test
    public void whenInvoiceHasTotalThenExpectTotal() {

        Invoice invoice = ImmutableInvoice.builder()
            .orderId(1)
            .timestamp(LocalDateTime.now())
            .total(new BigDecimal("1.00"))
            .build();

        Assertions.assertEquals(new BigDecimal("1.00"), invoice.total());
    }

    @Test
    public void whenInvoiceBuildDoesNotHaveTotalThenExpectException() {

        ImmutableInvoice.Builder builder = ImmutableInvoice.builder()
            .orderId(1)
            .timestamp(LocalDateTime.now());

        Assertions.assertThrows(IllegalStateException.class, () -> builder.build());
    }

    @Test
    public void whenInvoiceHasItemsThenExpectItems() {

        Invoice invoice = ImmutableInvoice.builder()
            .orderId(1)
            .timestamp(LocalDateTime.now())
            .total(BigDecimal.ZERO)
            .addItems(createItem())
            .build();

        Assertions.assertEquals(List.of(createItem()), invoice.items());
    }

    @Test
    public void whenInvocieBuilderHasNullItemsThenExpectException() {

        ImmutableInvoice.Builder builder = ImmutableInvoice.builder()
            .orderId(1)
            .timestamp(LocalDateTime.now())
            .total(BigDecimal.ZERO);

        Assertions.assertThrows(NullPointerException.class, () -> builder.items(null));
    }

    @Test
    public void whenInvoiceToStringThenExpectValue() {

        String expected = "Invoice{orderId=1, timestamp=2023-01-07T22:54, total=1.0, items=[Item{productId=1, productName=Product Name, quantity=1, total=1}]}";

        Invoice invoice = createInvoice();

        Assertions.assertEquals(expected, invoice.toString());
    }

    @Test
    public void whenInvoiceEqualsIsSameInstanceThenExpectTrue() {

        Invoice invoice1 = createInvoice();
        Invoice invoice2 = invoice1;

        Assertions.assertTrue(invoice1.equals(invoice2));
    }

    @Test
    public void whenInvoiceEqualsIsDifferentTypeThenExpectFalse() {

        Invoice invoice = createInvoice();
        Object object = new Object();

        Assertions.assertFalse(invoice.equals(object));
    }

    @Test
    public void whenInvoiceEqualsIsEqualThenExpectTrue() {

        Invoice invoice1 = createInvoice(1);
        Invoice invoice2 = createInvoice(1);

        Assertions.assertTrue(invoice1.equals(invoice2));
    }

    @Test

    public void whenInvoiceEqualsIsNotEqualThenExpectFalse() {

        Invoice invoice1 = createInvoice(1);
        Invoice invoice2 = createInvoice(2);

        Assertions.assertFalse(invoice1.equals(invoice2));
    }

    @Test
    public void whenInvoiceHashCodeThenExpectValue() {

        Invoice invoice = createInvoice();

        Assertions.assertEquals(1869975707, invoice.hashCode());
    }

    private Invoice createInvoice() {

        return createInvoice(1);
    }

    private Invoice createInvoice(Integer orderId) {

        return ImmutableInvoice.builder()
            .orderId(orderId)
            .timestamp(LocalDateTime.parse("2023-01-07T22:54:00"))
            .total(new BigDecimal("1.0"))
            .addItems(createItem())
            .build();
    }

    private Invoice.Item createItem() {

        return createItem(1);
    }

    private Invoice.Item createItem(Integer productId) {

        return ImmutableItem.builder()
            .productId(productId)
            .productName("Product Name")
            .quantity(1)
            .total(new BigDecimal("1"))
            .build();
    }
    
}
