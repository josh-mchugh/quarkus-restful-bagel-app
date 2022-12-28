package com.communitybagelco.order.entity;

import com.communitybagelco.order.model.Order;
import com.communitybagelco.order.resource.model.OrderBody;

public interface OrderRepository {
 
    Order create(OrderBody request);
}
