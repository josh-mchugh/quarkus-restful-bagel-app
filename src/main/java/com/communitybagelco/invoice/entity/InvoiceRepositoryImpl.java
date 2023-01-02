package com.communitybagelco.invoice.entity;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;

import org.jooq.DSLContext;
import org.jooq.generated.tables.Invoices;

import com.communitybagelco.invoice.model.ImmutableInvoice;
import com.communitybagelco.invoice.model.Invoice;

import lombok.RequiredArgsConstructor;

@ApplicationScoped
@Transactional
@RequiredArgsConstructor
public class InvoiceRepositoryImpl implements InvoiceRepository {
    
    private final DSLContext dsl;

    @Override
    public Invoice findByOrderId(Integer orderId) {
        
        return dsl.selectFrom(Invoices.INVOICES)
            .where(Invoices.INVOICES.ORDER_ID.eq(orderId))
            .fetchOneInto(ImmutableInvoice.class);
    } 
}
