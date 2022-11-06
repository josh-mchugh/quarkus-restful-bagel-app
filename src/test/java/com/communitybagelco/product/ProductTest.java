package com.communitybagelco.product;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.communitybagelco.category.Category;

public class ProductTest {
    
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
    public void whenProductHasCategoryThenExpectCategory() {

        Category category = new Category();

        Product product = new Product();
        product.setCategory(category);

        Assertions.assertEquals(category, product.getCategory());
    }
}
