package com.communitybagelco.menu.model;

import java.math.BigDecimal;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import nl.jqno.equalsverifier.EqualsVerifier;
import nl.jqno.equalsverifier.Warning;

public class MenuItemTest {

    @Test
    public void whenImmutableMenuItemHasProductIdThenExpectProductId() {

        ImmutableMenuItem item = ImmutableMenuItem.builder()
            .productId(1)
            .build();

        Assertions.assertEquals(1, item.productId());
    }

    @Test
    public void whenImmutableMenuItemHasNameThenExpectName() {

        ImmutableMenuItem item = ImmutableMenuItem.builder()
            .name("name")
            .build();

        Assertions.assertEquals("name", item.name());
    }

    @Test
    public void whenImmutableMenuItemHasPriceThenExpectPrice() {

        ImmutableMenuItem item = ImmutableMenuItem.builder()
            .price(new BigDecimal("1.75"))
            .build();

        Assertions.assertEquals(new BigDecimal("1.75"), item.price());
    }

    @Test
    public void whenImmutableMenuItemToStringThenExpectString() {

        String expected = "MenuItem{productId=1, name=name, price=1.75}";

        Assertions.assertEquals(expected, createImmutableMenuItem().toString());
    }

    @Test
    public void whenImmutableMenuItemHashCodeThenExpectHashCode() {

        Assertions.assertEquals(304715844, createImmutableMenuItem().hashCode());
    }

    @Test
    public void whenImmutableMenuItemEmptyHashCodeThenExpectHashCode() {

        ImmutableMenuItem item = ImmutableMenuItem.builder().build();

        Assertions.assertEquals(193376997, item.hashCode());
    }
    
    @Test
    public void whenImmutableMenuItemIsEqualThenExpectTrue() {

        ImmutableMenuItem item1 = createImmutableMenuItem();
        ImmutableMenuItem item2 = createImmutableMenuItem();

        Assertions.assertTrue(item1.equals(item2));
    }

    @Test
    public void whenImmutableMenuItemEqualsIsSameInstanceThenExpectTrue() {

        ImmutableMenuItem item1 = createImmutableMenuItem();
        ImmutableMenuItem item2 = item1;

        Assertions.assertTrue(item1.equals(item2));
    }

    @Test
    public void whenImmutableMenuItemEqualsIsNotEqualThenExpectFalse() {

        ImmutableMenuItem item1 = createImmutableMenuItem(1);
        ImmutableMenuItem item2 = createImmutableMenuItem(2);

        Assertions.assertFalse(item1.equals(item2));
    }

    @Test
    public void whenImmutableMenuItemEqualsIsNotSameTypethenExpectFalse() {

        ImmutableMenuItem item1 = createImmutableMenuItem();
        Object object = new Object();

        Assertions.assertFalse(item1.equals(object));
    }

    @Test
    public void whenImmutableMenuItemEqualsIsNullThenExpectFalse() {

        ImmutableMenuItem item = createImmutableMenuItem();
        
        Assertions.assertFalse(item.equals(null));
    }

    @Test
    public void immutableMenuItemEqualsContract() {

        EqualsVerifier.simple().forClass(ImmutableMenuItem.class)
            .suppress(Warning.BIGDECIMAL_EQUALITY)
            .verify();
    }

    private ImmutableMenuItem createImmutableMenuItem() {

        return createImmutableMenuItem(1);
    }

    private ImmutableMenuItem createImmutableMenuItem(Integer id) {

        return ImmutableMenuItem.builder()
            .productId(id)
            .name("name")
            .price(new BigDecimal("1.75"))
            .build();
    }
}
