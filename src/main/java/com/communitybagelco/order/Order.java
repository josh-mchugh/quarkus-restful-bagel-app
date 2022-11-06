package com.communitybagelco.order;

import java.util.List;

import com.communitybagelco.product.Product;

public class Order {
    
    private Integer id;
    private List<Product> products;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
