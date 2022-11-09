package com.communitybagelco.order;

import java.util.List;

import com.communitybagelco.product.Product;

import lombok.Data;

@Data
public class Order {
    
    private Integer id;
    private List<Product> products;
}
