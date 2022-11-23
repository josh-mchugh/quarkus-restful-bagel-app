package com.communitybagelco.product;

import java.math.BigDecimal;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ProductTest {
    
    @Test
    public void whenProductHasIdThenExpectId() {

        Product product = new Product();
        product.setId(1);

        Assertions.assertEquals(1, product.getId());
    }

    @Test
    public void whenProductHasNameThenExpectName() {

        Product product = new Product();
        product.setName("name");
            
        Assertions.assertEquals("name", product.getName());
    }

    @Test
    public void whenProductHasDescriptionThenExpectDescription() {

        Product product = new Product();
        product.setDescription("description");

        Assertions.assertEquals("description", product.getDescription());
    }

    @Test
    public void whenProductHasPriceThenExpectPrice() {

        Product product = new Product();
        product.setPrice(new BigDecimal("1.75"));

        Assertions.assertEquals(new BigDecimal("1.75"), product.getPrice());
    }

    @Test
    public void whenProductHasCategoryThenExpectCategory() {

        //Category category = new Category("test");

        //Product product = new Product();
        //product.setCategory(category);

        //Assertions.assertEquals(category, product.getCategory());
    }
}
