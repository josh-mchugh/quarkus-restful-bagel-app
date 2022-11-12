package com.communitybagelco.order;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

import javax.enterprise.context.ApplicationScoped;

import com.communitybagelco.product.Product;
import com.communitybagelco.product.ProductService;

import lombok.RequiredArgsConstructor;

@ApplicationScoped
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {
    
    private final ProductService productService;

    private AtomicInteger counter = new AtomicInteger();

    @Override
    public Order handleOrder(OrderRequest request) {

        Order order = new Order();
        order.setId(counter.incrementAndGet());

        if(request != null && request.getProductIds() != null) {
     
            List<Product> products = productService.getByIds(request.getProductIds());
            Double total = products.stream().collect(Collectors.summingDouble(Product::getPrice));

            order.setProducts(products);
            order.setTotal(total);
        }
        
        return order;
    }
}
