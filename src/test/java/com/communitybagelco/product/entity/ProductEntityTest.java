package com.communitybagelco.product.entity;

import java.math.BigDecimal;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ProductEntityTest {
    
    @Test
    public void whenEntityHasIdThenExpectId() {

        ProductEntity entity = new ProductEntity();
        entity.setId(1);

        Assertions.assertEquals(1, entity.getId());
    }

    @Test
    public void whenEntityHasNameThenExpectName() {

        ProductEntity entity = new ProductEntity();
        entity.setName("name");
            
        Assertions.assertEquals("name", entity.getName());
    }

    @Test
    public void whenEntityHasDescriptionThenExpectDescription() {

        ProductEntity entity = new ProductEntity();
        entity.setDescription("description");

        Assertions.assertEquals("description", entity.getDescription());
    }

    @Test
    public void whenEntityHasPriceThenExpectPrice() {

        ProductEntity entity = new ProductEntity();
        entity.setPrice(new BigDecimal("1.75"));

        Assertions.assertEquals(new BigDecimal("1.75"), entity.getPrice());
    }
}
