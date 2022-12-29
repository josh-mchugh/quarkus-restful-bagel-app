package com.communitybagelco.order.service.model;

import java.util.List;

import org.immutables.value.Value;

@Value.Immutable
public abstract class OrderRequest {
    
    public abstract List<Item> items();

    @Value.Immutable
    public interface Item {

        public abstract Integer productId();
        public abstract Integer quantity();
    }
}
