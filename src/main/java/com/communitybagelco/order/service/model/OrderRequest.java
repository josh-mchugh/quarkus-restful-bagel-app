package com.communitybagelco.order.service.model;

import java.util.List;

import io.quarkus.runtime.annotations.RegisterForReflection;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@RegisterForReflection
public class OrderRequest {
    
    private List<Item> items;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Item {

        private Integer productId;
        private Integer quantity;
    }
}
