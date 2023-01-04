package com.communitybagelco.invoice.entity.model;

import org.immutables.value.Value;

@Value.Immutable
public abstract class InvoiceRequest {
   
    public abstract Integer orderId();
}
