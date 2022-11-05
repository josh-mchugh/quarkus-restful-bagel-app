package com.communitybagelco.inventory;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class InventoryTest {
    
    @Test
    public void whenInventoryHasNameThenExpectName() {

        Inventory inventory = new Inventory();
        inventory.setName("name");

        Assertions.assertEquals("name", inventory.getName());
    }

    @Test
    public void whenInventoryHasDescriptionThenExpectDescription() {

        Inventory inventory = new Inventory();
        inventory.setDescription("description");

        Assertions.assertEquals("description", inventory.getDescription());
    }
}
