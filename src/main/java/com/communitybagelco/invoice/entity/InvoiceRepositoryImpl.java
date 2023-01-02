package com.communitybagelco.invoice.entity;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;

import org.jooq.DSLContext;
import org.jooq.impl.DSL;

import com.communitybagelco.invoice.model.ImmutableInvoice;
import com.communitybagelco.invoice.model.ImmutableItem;
import com.communitybagelco.invoice.model.Invoice;

import lombok.RequiredArgsConstructor;

import static org.jooq.generated.tables.Invoices.INVOICES;
import static org.jooq.generated.tables.InvoiceItems.INVOICE_ITEMS;

@ApplicationScoped
@Transactional
@RequiredArgsConstructor
public class InvoiceRepositoryImpl implements InvoiceRepository {
    
    private final DSLContext dsl;

    @Override
    public Invoice findByOrderId(Integer orderId) {
        
        return dsl.select(
                INVOICES.ORDER_ID,
                INVOICES.TIMESTAMP,
                INVOICES.TOTAL,
                DSL.multiset(
                    dsl.select(
                        INVOICE_ITEMS.PRODUCT_ID,
                        INVOICE_ITEMS.PRODUCTNAME,
                        INVOICE_ITEMS.QUANTITY,
                        INVOICE_ITEMS.TOTAL
                    )
                    .from(INVOICE_ITEMS)
                    .where(INVOICE_ITEMS.ORDER_ID.eq(orderId))
                ).convertFrom(r -> r.into(ImmutableItem.class))
            )
            .from(INVOICES)
            .where(INVOICES.ORDER_ID.eq(orderId))
            .fetchOneInto(ImmutableInvoice.class);
    } 
}
