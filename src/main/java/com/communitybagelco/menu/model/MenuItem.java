package com.communitybagelco.menu.model;

import java.math.BigDecimal;

import org.immutables.value.Value;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import io.smallrye.common.constraint.Nullable;

@Value.Immutable
@JsonSerialize(as = ImmutableMenuItem.class)
@JsonDeserialize(as = ImmutableMenuItem.class)
public abstract class MenuItem {

    @Nullable
    public abstract Integer productId();

    @Nullable
    public abstract String name();

    @Nullable
    public abstract BigDecimal price();
}
