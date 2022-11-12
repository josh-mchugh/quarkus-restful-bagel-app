package com.communitybagelco.product;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.communitybagelco.category.Category;

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
        .price(1.75D)
            .build();

            Assertions.assertEquals(1.75D, product.getPrice());
    }

    @Test
    public void whenProductHasCategoryThenExpectCategory() {

        Category category = new Category();

        Product product = Product.builder()
            .category(category)
            .build();

        Assertions.assertEquals(category, product.getCategory());
    }
}
