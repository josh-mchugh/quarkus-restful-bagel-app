package com.communitybagelco.order.service;

import com.communitybagelco.order.model.Order;
import com.communitybagelco.order.service.model.OrderRequest;

public interface OrderService {

    Order handleOrder(OrderRequest request);
}
