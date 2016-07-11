package com.cane.repository;

import com.cane.common.dao.AbstractDao;
import com.cane.model.ClientDataEntity;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by xu_kanfeng on 16/6/29.
 */
@Repository
public class ClientDataDao extends AbstractDao {
    public ClientDataEntity getClientDataByTaxpayerId(String taxpayerId){
        Map<String,String> map = new HashMap<String, String>();
        map.put("taxpayerId",taxpayerId);
        return sqlSession.selectOne(sql(), map);
    }
    public ClientDataEntity getClientDataByWechatIdAndCompanyName(String wechatId, String companyName){
        Map<String,String> map = new HashMap<String, String>();
        map.put("wechatId",wechatId);
        map.put("companyName",companyName);
        return sqlSession.selectOne(sql(), map);
    }
    public List<ClientDataEntity> getClientDataListByWechatId(String wechatId){
        Map<String,String> map = new HashMap<String, String>();
        map.put("wechatId",wechatId);
        return sqlSession.selectList(sql(), map);
    }
    public List<ClientDataEntity> getClientDataListByCompanyName(String companyName){
        Map<String,String> map = new HashMap<String, String>();
        map.put("companyName",companyName);
        return sqlSession.selectList(sql(), map);
    }
    public List<ClientDataEntity> getClientDataListByTaxpayerId(String taxpayerId){
        Map<String,String> map = new HashMap<String, String>();
        map.put("taxpayerId",taxpayerId);
        return sqlSession.selectList(sql(), map);
    }
    public List<ClientDataEntity> getClientDataList() {return sqlSession.selectList(sql());}

    public void addClientData(ClientDataEntity clientData) {sqlSession.insert(sql(), clientData);}
}
