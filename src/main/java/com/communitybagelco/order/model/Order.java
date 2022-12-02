package com.communitybagelco.order.model;

import java.time.LocalDateTime;

import io.quarkus.runtime.annotations.RegisterForReflection;
import lombok.Builder;
import lombok.Value;

@Value
@Builder(builderClassName = "Builder")
@RegisterForReflection
public class Order {
    
    Integer id;
    LocalDateTime timestamp;
}
