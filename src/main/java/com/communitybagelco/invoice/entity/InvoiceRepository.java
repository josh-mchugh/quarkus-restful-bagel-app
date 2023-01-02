package com.communitybagelco.invoice.entity;

import com.communitybagelco.invoice.model.Invoice;

public interface InvoiceRepository {
    
    Invoice findByOrderId(Integer orderId);
}
