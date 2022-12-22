package com.communitybagelco.menu.model;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class MenuItem {

    private Integer productId;
    private String name;
    private BigDecimal price;
}
