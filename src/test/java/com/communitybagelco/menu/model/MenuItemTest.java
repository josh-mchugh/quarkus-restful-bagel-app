package com.communitybagelco.menu.model;

import java.math.BigDecimal;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import nl.jqno.equalsverifier.EqualsVerifier;
import nl.jqno.equalsverifier.Warning;

public class MenuItemTest {
    
    @Test
    public void whenMenuItemItemHasProductIdThenExpectProductId() {

        MenuItem item = ImmutableMenuItem.builder()
            .productId(1)
            .build();

        Assertions.assertEquals(1, item.productId());
    }

    @Test
    public void whenMenuItemItemHasNameThenExpectName() {

        MenuItem item = ImmutableMenuItem.builder()
            .name("name")
            .build();

        Assertions.assertEquals("name", item.name());
    }

    @Test
    public void whenMenuItemItemHasPriceThenExpectPrice() {

        MenuItem item = ImmutableMenuItem.builder()
            .price(new BigDecimal("1.75"))
            .build();

        Assertions.assertEquals(new BigDecimal("1.75"), item.price());
    }

    @Test
    public void whenMenuItemItemToStringThenExpectString() {

        String expected = "MenuItem{productId=1, name=name, price=1.75}";

        Assertions.assertEquals(expected, createMenuItem().toString());
    }

    @Test
    public void whenMenuItemItemHashCodeThenExpectHashCode() {

        Assertions.assertEquals(304715844, createMenuItem().hashCode());
    }

    @Test
    public void whenMenuItemItemEmptyHashCodeThenExpectHashCode() {

        MenuItem item = ImmutableMenuItem.builder().build();

        Assertions.assertEquals(193376997, item.hashCode());
    }
    
    @Test
    public void whenMenuItemItemIsEqualThenExpectTrue() {

        MenuItem item1 = createMenuItem();
        MenuItem item2 = createMenuItem();

        Assertions.assertTrue(item1.equals(item2));
    }

    @Test
    public void whenMenuItemItemEqualsIsSameInstanceThenExpectTrue() {

        MenuItem item1 = createMenuItem();
        MenuItem item2 = item1;

        Assertions.assertTrue(item1.equals(item2));
    }

    @Test
    public void whenMenuItemItemEqualsIsNotEqualThenExpectFalse() {

        MenuItem item1 = createMenuItem(1);
        MenuItem item2 = createMenuItem(2);

        Assertions.assertFalse(item1.equals(item2));
    }

    @Test
    public void whenMenuItemItemEqualsIsNotSameTypethenExpectFalse() {

        MenuItem item1 = createMenuItem();
        Object object = new Object();

        Assertions.assertFalse(item1.equals(object));
    }

    @Test
    public void whenMenuItemItemEqualsIsNullThenExpectFalse() {

        MenuItem item = createMenuItem();
        
        Assertions.assertFalse(item.equals(null));
    }

    @Test
    public void menuItemEqualsContract() {

        EqualsVerifier.simple().forClass(ImmutableMenuItem.class)
            .suppress(Warning.BIGDECIMAL_EQUALITY)
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
