package com.communitybagelco.product;

import com.communitybagelco.category.Category;

import lombok.Builder;
import lombok.Data;

@Data
@Builder(builderClassName = "Builder")
public class Product {
    
    private String name;
    private String description;
    private Category category;
}
