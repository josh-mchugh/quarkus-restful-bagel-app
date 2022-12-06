package com.communitybagelco.product.model;

import com.communitybagelco.product.entity.ProductEntity;

public class ProductMapper {

    private ProductMapper() {
        
    }
    
    public static Product map(ProductEntity entity) {

        if(entity == null) {

            return null;
        }

        return Product.builder()
            .id(entity.getId())
            .name(entity.getName())
            .description(entity.getDescription())
            .price(entity.getPrice())
            .build();
    }
}
