package com.communitybagelco.product.model;

import java.math.BigDecimal;

import io.quarkus.runtime.annotations.RegisterForReflection;
import lombok.Builder;
import lombok.Value;

@Value
@Builder(builderClassName = "Builder")
@RegisterForReflection
public class Product {
    
    Integer id;
    String name;
    String description;
    BigDecimal price;
}
