package com.communitybagelco.product;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ProductTest {
    
    @Test
    public void whenInventoryHasNameThenExpectName() {

        Product inventory = new Product();
        inventory.setName("name");

        Assertions.assertEquals("name", inventory.getName());
    }

    @Test
    public void whenInventoryHasDescriptionThenExpectDescription() {

        Product inventory = new Product();
        inventory.setDescription("description");

        Assertions.assertEquals("description", inventory.getDescription());
    }
}
