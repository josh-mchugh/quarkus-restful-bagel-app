package com.communitybagelco.order.service.model;

import java.util.List;

import io.quarkus.runtime.annotations.RegisterForReflection;
import lombok.Data;

@Data
@RegisterForReflection
public class OrderRequest {
    
    private List<Integer> productIds;
}
