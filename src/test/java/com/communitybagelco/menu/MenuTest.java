package com.communitybagelco.menu;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MenuTest {

    @Test
    public void whenMenuUsesDefaultConstructorExpectItemEmptyList() {

        Assertions.assertEquals(List.of(), new Menu().getItems());
    }

    @Test
    public void whenMenuUsesConstructorForItemsThenExpectItemsList() {

        List<Menu.Item> items = List.of(
            new Menu.Item("name", "description")
        );

        Assertions.assertEquals(items, new Menu(items).getItems());
    }

    @Test
    public void whenMenuItemHasNameThenExpectName() {

        Menu.Item item = new Menu.Item("name", null);

        Assertions.assertEquals("name", item.getName());
    }

    @Test
    public void whenMenuItemHasDescriptionThenExpectDescription() {

        Menu.Item item = new Menu.Item(null, "description");

        Assertions.assertEquals("description", item.getDescription());
    }
}
