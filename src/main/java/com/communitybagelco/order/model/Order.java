package com.communitybagelco.order.model;

import io.quarkus.runtime.annotations.RegisterForReflection;
import lombok.Value;

@Value
@RegisterForReflection
public class Order {
    
    Integer id;
}
