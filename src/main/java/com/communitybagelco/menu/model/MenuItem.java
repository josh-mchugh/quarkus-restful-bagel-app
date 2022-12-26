package com.communitybagelco.menu.model;

import java.math.BigDecimal;

import org.immutables.value.Value;

@Value.Immutable
public abstract class MenuItem {

    public abstract Integer productId();
    public abstract String name();
    public abstract BigDecimal price();
}
