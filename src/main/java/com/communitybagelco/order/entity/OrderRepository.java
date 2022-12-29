package com.communitybagelco.order.entity;

import com.communitybagelco.order.service.model.OrderRequest;
import com.communitybagelco.order.service.model.OrderResponse;

public interface OrderRepository {
 
    OrderResponse create(OrderRequest request);
}
