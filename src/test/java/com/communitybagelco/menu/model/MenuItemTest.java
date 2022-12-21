package com.communitybagelco.menu.model;

import java.math.BigDecimal;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MenuItemTest {

    @Test
    public void whenMenuItemHasIdThenExpectId() {

        MenuItem item = new MenuItem();
        item.setId(1);

        Assertions.assertEquals(1, item.getId());
    }

    @Test
    public void whenMenuItemHasNameThenExpectName() {

        MenuItem item = new MenuItem();
        item.setName("name");

        Assertions.assertEquals("name", item.getName());
    }

    @Test
    public void whenMenuItemHasPriceThenExpectPrice() {

        MenuItem item = new MenuItem();
        item.setPrice(new BigDecimal("1.75"));

        Assertions.assertEquals(new BigDecimal("1.75"), item.getPrice());
    }

    @Test
    public void whenMenuItemToStringThenExpectString() {

        String expected = "MenuItem(id=1, name=name, price=1.75)";

        Assertions.assertEquals(expected, createMenuItem().toString());
    }

    @Test
    public void whenMenuItemHashCodeThenExpectHashCode() {

        Assertions.assertEquals(199263000, createMenuItem().hashCode());
    }

    @Test
    public void whenMenuItemEmptyHashCodeThenExpectHashCode() {

        Assertions.assertEquals(357642, new MenuItem().hashCode());
    }
    
    @Test
    public void whenMenuItemIsEqualThenExpectTrue() {

        MenuItem item1 = createMenuItem();
        MenuItem item2 = createMenuItem();

        Assertions.assertTrue(item1.equals(item2));
    }

    @Test
    public void whenMenuItemEqualsIsSameInstanceThenExpectTrue() {

        MenuItem item1 = createMenuItem();
        MenuItem item2 = item1;

        Assertions.assertTrue(item1.equals(item2));
    }

    @Test
    public void whenMenuItemEqualsIsNotEqualThenExpectFalse() {

        MenuItem item1 = createMenuItem(1);
        MenuItem item2 = createMenuItem(2);

        Assertions.assertFalse(item1.equals(item2));
    }

    @Test
    public void whenMenuItemEqualsIsNotSameTypethenExpectFalse() {

        MenuItem item1 = createMenuItem();
        Object object = new Object();

        Assertions.assertFalse(item1.equals(object));
    }

    @Test
    public void whenMenuItemEqualsIsNullThenExpectFalse() {

        MenuItem item = createMenuItem();
        
        Assertions.assertFalse(item.equals(null));
    }

    private MenuItem createMenuItem() {

        return createMenuItem(1);
    }

    private MenuItem createMenuItem(Integer id) {

        MenuItem item = new MenuItem();
        item.setId(id);
        item.setName("name");
        item.setPrice(new BigDecimal("1.75"));

        return item;
    }
    
}
