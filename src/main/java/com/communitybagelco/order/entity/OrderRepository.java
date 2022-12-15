package com.communitybagelco.order.entity;

import com.communitybagelco.order.model.Order;
import com.communitybagelco.order.service.model.OrderRequest;

public interface OrderRepository {
 
    Order create(OrderRequest request);
}
