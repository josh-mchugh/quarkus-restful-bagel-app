package com.communitybagelco.product.model;

import lombok.Builder;
import lombok.Value;

@Value
@Builder(builderClassName = "Builder")
public class Product {
    
    Integer id;
    String name;
    String description;
    Float price;
}
