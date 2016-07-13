package com.cane.repository;

import com.cane.common.dao.AbstractDao;
import com.cane.model.InvoiceHeaderEntity;
import org.springframework.stereotype.Repository;

/**
 * Created by xu_kanfeng on 16/1/24.
 */
@Repository
public class InvoiceHeaderDao extends AbstractDao{
    public void addInvoiceHeader(InvoiceHeaderEntity invoiceHeaderEntity) {
        sqlSession.insert(sql(), invoiceHeaderEntity);
    }
}
