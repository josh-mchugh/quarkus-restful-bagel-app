package com.communitybagelco.invoice.entity;

import java.util.Optional;

import com.communitybagelco.invoice.entity.model.InvoiceRequest;
import com.communitybagelco.invoice.model.Invoice;

public interface InvoiceRepository {
    
    Optional<Invoice> findByOrderId(InvoiceRequest request);
}
