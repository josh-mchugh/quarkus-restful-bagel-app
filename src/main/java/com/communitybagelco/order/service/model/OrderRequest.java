package com.communitybagelco.order.service.model;

import java.util.ArrayList;
import java.util.List;

import org.immutables.value.Value;

import io.smallrye.common.constraint.Nullable;

@Value.Immutable
public abstract class OrderRequest {
    
    @Value.Default
    public List<Item> items() {

        return new ArrayList<>();
    }

    @Value.Immutable
    public interface Item {

        @Nullable
        public abstract Integer productId();
        
        @Nullable
        public abstract Integer quantity();
    }
}
