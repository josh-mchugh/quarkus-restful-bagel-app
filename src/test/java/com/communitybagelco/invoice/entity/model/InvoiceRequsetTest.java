package com.communitybagelco.invoice.entity.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import nl.jqno.equalsverifier.EqualsVerifier;

public class InvoiceRequsetTest {

    @Test
    public void whenRequestHasOrderIdThenExpectOrderId() {

        InvoiceRequest request = ImmutableInvoiceRequest.builder()
            .orderId(1)
            .build();

        Assertions.assertEquals(1, request.orderId());
    }
    
    @Test
    public void whenRequestHasNullOrderIdThenExpectException() {

        ImmutableInvoiceRequest.Builder builder = ImmutableInvoiceRequest.builder();

        Assertions.assertThrows(IllegalStateException.class, () -> builder.build());
    }

    @Test
    public void whenRequestToStringThenExpectToString() {

        String expected = "InvoiceRequest{orderId=1}";

        InvoiceRequest request = createRequest();

        Assertions.assertEquals(expected, request.toString());
    }

    @Test
    public void whenRequestHashCodeThenExpectValue() {

        InvoiceRequest request = createRequest();

        Assertions.assertEquals(177574, request.hashCode());
    }

    @Test
    public void whenRequestEqualsIsSameInstanceThenExpectTrue() {

        InvoiceRequest request1 = createRequest();
        InvoiceRequest request2 = request1;

        Assertions.assertTrue(request1.equals(request2));
    }

    @Test
    public void whenRequestEqualsIsDifferentTypeThenExpectFalse() {

        InvoiceRequest request = createRequest();
        Object object = new Object();

        Assertions.assertFalse(request.equals(object));
    }

    @Test
    public void whenRequestEqualsIsTrueThenExpectTrue() {

        InvoiceRequest request1 = createRequest(1);
        InvoiceRequest request2 = createRequest(1);

        Assertions.assertTrue(request1.equals(request2));
    }

    @Test
    public void whenRequestEqualsIsNotEqualThenExpectFalse() {

        InvoiceRequest request1 = createRequest(1);
        InvoiceRequest request2 = createRequest(2);

        Assertions.assertFalse(request1.equals(request2));
    }

    @Test
    public void invoiceRequestEqualsContract() {

        EqualsVerifier.simple().forClass(ImmutableInvoiceRequest.class)
            .withNonnullFields("orderId")
            .withResetCaches()
            .verify();
    }

    private InvoiceRequest createRequest() {

        return createRequest(1);
    }

    private InvoiceRequest createRequest(Integer orderId) {

        return ImmutableInvoiceRequest.builder()
            .orderId(orderId)
            .build();
    }

    
}
