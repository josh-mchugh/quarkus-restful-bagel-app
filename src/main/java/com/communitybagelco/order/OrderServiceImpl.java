package com.communitybagelco.order;

import java.math.BigDecimal;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

import javax.enterprise.context.ApplicationScoped;

import com.communitybagelco.product.entity.ProductEntity;
import com.communitybagelco.product.entity.ProductRepository;

import lombok.RequiredArgsConstructor;

@ApplicationScoped
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {
    
    private final ProductRepository productRepository;

    private AtomicInteger counter = new AtomicInteger();

    @Override
    public Order handleOrder(OrderRequest request) {

        Order order = new Order();
        order.setId(counter.incrementAndGet());

        if(request != null && request.getProductIds() != null) {
     
            List<ProductEntity> products = productRepository.getByIds(request.getProductIds());
            BigDecimal total = products.stream().collect(Collectors.reducing(BigDecimal.ZERO, ProductEntity::getPrice, BigDecimal::add));

            order.setProducts(products);
            order.setTotal(total);
        }
        
        return order;
    }
}
