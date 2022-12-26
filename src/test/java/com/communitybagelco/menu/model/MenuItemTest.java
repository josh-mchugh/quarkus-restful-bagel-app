package com.communitybagelco.menu.model;

import java.math.BigDecimal;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import nl.jqno.equalsverifier.EqualsVerifier;
import nl.jqno.equalsverifier.Warning;

public class MenuItemTest {

    @Test
    public void whenMenuItemHasProductIdThenExpectProductId() {

        MenuItem item = ImmutableMenuItem.builder()
            .productId(1)
            .build();

        Assertions.assertEquals(1, item.productId());
    }

    @Test
    public void whenMenuItemHasNameThenExpectName() {

        MenuItem item = ImmutableMenuItem.builder()
            .name("name")
            .build();

        Assertions.assertEquals("name", item.name());
    }

    @Test
    public void whenMenuItemHasPriceThenExpectPrice() {

        MenuItem item = ImmutableMenuItem.builder()
            .price(new BigDecimal("1.75"))
            .build();

        Assertions.assertEquals(new BigDecimal("1.75"), item.price());
    }

    @Test
    public void whenMenuItemToStringThenExpectString() {

        String expected = "MenuItem(productId=1, name=name, price=1.75)";

        Assertions.assertEquals(expected, createMenuItem().toString());
    }

    @Test
    public void whenMenuItemHashCodeThenExpectHashCode() {

        Assertions.assertEquals(199263000, createMenuItem().hashCode());
    }

    @Test
    public void whenMenuItemEmptyHashCodeThenExpectHashCode() {

        MenuItem item = ImmutableMenuItem.builder().build();

        Assertions.assertEquals(357642, item.hashCode());
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

    @Test
    public void menuItemContract() {

        EqualsVerifier.simple().forClass(ImmutableMenuItem.class)
            .suppress(Warning.INHERITED_DIRECTLY_FROM_OBJECT)
            .verify();
    }

    private MenuItem createMenuItem() {

        return createMenuItem(1);
    }

    private MenuItem createMenuItem(Integer id) {

        return ImmutableMenuItem.builder()
            .productId(id)
            .name("name")
            .price(new BigDecimal("1.75"))
            .build();
    }
    
}
