package com.communitybagelco.order;

import java.util.List;

import io.quarkus.runtime.annotations.RegisterForReflection;
import lombok.Data;

@Data
@RegisterForReflection
public class OrderRequest {
    
    private List<Integer> productIds;
}
