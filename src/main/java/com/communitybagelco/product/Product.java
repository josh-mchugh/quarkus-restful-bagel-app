package com.communitybagelco.product;

import com.communitybagelco.category.Category;

import io.quarkus.runtime.annotations.RegisterForReflection;
import lombok.Builder;
import lombok.Data;

@Data
@Builder(builderClassName = "Builder")
@RegisterForReflection
public class Product {
    
    private Integer id;
    private String name;
    private String description;
    private Category category;
}
