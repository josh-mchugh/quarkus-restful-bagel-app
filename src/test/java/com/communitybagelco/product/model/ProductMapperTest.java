package com.communitybagelco.product.model;

import java.math.BigDecimal;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.communitybagelco.product.entity.ProductEntity;

public class ProductMapperTest {

    @Test
    public void whenEntityIsNullThenExpectNull() {

        Assertions.assertNull(ProductMapper.map((ProductEntity) null));
    }

    @Test
    public void whenEntityHasIdThenExpectId() {

        ProductEntity entity = new ProductEntity();
        entity.setId(1);

        Product product = ProductMapper.map(entity);

        Assertions.assertEquals(1, product.getId());
    }

    @Test
    public void whenEntityHasNameThenExpectName() {

        ProductEntity entity = new ProductEntity();
        entity.setName("name");

        Product product = ProductMapper.map(entity);

        Assertions.assertEquals("name", product.getName());
    }

    @Test
    public void whenEntityHasDescriptionThenExpectDescription() {

        ProductEntity entity = new ProductEntity();
        entity.setDescription("description");

        Product product = ProductMapper.map(entity);

        Assertions.assertEquals("description", product.getDescription());
    }

    @Test
    public void whenEntityHasPriceThenExpectPrice() {

        ProductEntity entity = new ProductEntity();
        entity.setPrice(new BigDecimal("1.75"));

        Product product = ProductMapper.map(entity);

        Assertions.assertEquals(new BigDecimal("1.75"), product.getPrice());
    }
}
