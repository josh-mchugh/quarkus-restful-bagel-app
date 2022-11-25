package com.communitybagelco.product.model;

import java.math.BigDecimal;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ProductTest {

    @Test
    public void whenProductHasIdThenExpectId() {

        Product product = Product.builder()
            .id(1)
            .build();

        Assertions.assertEquals(1, product.getId());
    }

    @Test
    public void whenProductHasNameThenExpectName() {

        Product product = Product.builder()
            .name("name")
            .build();

        Assertions.assertEquals("name", product.getName());
    }

    @Test
    public void whenProductHasDescriptionThenExpectDescription() {

        Product product = Product.builder()
            .description("description")
            .build();

        Assertions.assertEquals("description", product.getDescription());
    }

    @Test
    public void whenProductHasPriceThenExpectPrice() {

        Product product = Product.builder()
            .price(new BigDecimal("1.75"))
            .build();

        Assertions.assertEquals(new BigDecimal("1.75"), product.getPrice());
    }
}
