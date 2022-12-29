package com.communitybagelco.order.service.model;

import org.immutables.value.Value;

@Value.Immutable
public abstract class OrderResponse {
 
    public abstract Integer orderId();
}
