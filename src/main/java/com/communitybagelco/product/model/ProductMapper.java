package com.communitybagelco.product.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

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

    public static List<Product> map(Collection<ProductEntity> entities) {

        if(entities == null) {

            return Collections.emptyList();
        }

        return entities.stream()
            .map(ProductMapper::map)
            .toList();
    }
}
