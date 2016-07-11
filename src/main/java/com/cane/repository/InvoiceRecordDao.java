package com.cane.repository;

import com.cane.common.dao.AbstractDao;
import com.cane.model.InvoiceRecordEntity;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by xu_kanfeng on 16/6/29.
 */
@Repository
public class InvoiceRecordDao extends AbstractDao {
    public InvoiceRecordEntity getInvoiceRecordByTaxpayerId(String taxpayerId){
        Map<String,String> map = new HashMap<String, String>();
        map.put("taxpayerId",taxpayerId);
        return sqlSession.selectOne(sql(), map);
    }
    public InvoiceRecordEntity getInvoiceRecordByCompanyNameOrTaxpayerId(String companyNameOrTaxpayerId){
        Map<String,String> map = new HashMap<String, String>();
        //if() 判断?应该模糊搜索,动态返回,怎么做?
        map.put("companyName",companyNameOrTaxpayerId);

        return sqlSession.selectOne(sql(), map);
    }
    public List<InvoiceRecordEntity> getInvoiceRecordList() {return sqlSession.selectList(sql());}
    public List<InvoiceRecordEntity> getInvoiceRecordListByTaxpayerId(String taxpayerId){
        Map<String,String> map = new HashMap<String, String>();
        map.put("taxpayerId",taxpayerId);
        return sqlSession.selectList(sql(), map);
    }
    public List<InvoiceRecordEntity> getInvoiceRecordListByCompanyName(String companyName){
        Map<String,String> map = new HashMap<String, String>();
        map.put("companyName",companyName);
        return sqlSession.selectList(sql(), map);
    }



}
