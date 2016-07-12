package com.cane.repository;

import com.cane.common.dao.AbstractDao;
import com.cane.model.TaxcontrolSettingEntity;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by xu_kanfeng on 16/6/29.
 */
@Repository
public class TaxcontrolSettingDao extends AbstractDao {

    public List<TaxcontrolSettingEntity> getTaxcontrolSettingList() {return sqlSession.selectList(sql());}

    public TaxcontrolSettingEntity getTaxcontrolSetting(String shopName, String machineId){
        Map<String,String> map = new HashMap<String, String>();
        map.put("shopName",shopName);
        map.put("machineId",machineId);
        return sqlSession.selectOne(sql(), map);
    }

    public TaxcontrolSettingEntity getTaxcontrolSettingByDefault(){
        Map<String,String> map = new HashMap<String, String>();
        map.put("isDefault", "1");
        return sqlSession.selectOne(sql(), map);
    }

    public void setTaxcontrolSettingDefault(TaxcontrolSettingEntity taxcontrolSetting){
        sqlSession.update(sql(), taxcontrolSetting);
    }

    public void addTaxcontrolSetting(TaxcontrolSettingEntity taxcontrolSetting) {sqlSession.insert(sql(), taxcontrolSetting);}

    public void deleteTaxcontrolSetting(String shopName, String machineId) {
        Map<String,String> map = new HashMap<String, String>();
        map.put("shopName",shopName);
        map.put("machineId",machineId);
        sqlSession.delete(sql(), map);
    }

    public void updateTaxcontrolSetting(String shopName, String machineId) {

    }

    public List<TaxcontrolSettingEntity> getTaxcontrolSettingListByTaxpayerId(String taxpayerId){
        Map<String,String> map = new HashMap<String, String>();
        map.put("taxpayerId",taxpayerId);
        return sqlSession.selectList(sql(), map);
    }
    public List<TaxcontrolSettingEntity> getTaxcontrolSettingListByCompanyName(String companyName){
        Map<String,String> map = new HashMap<String, String>();
        map.put("companyName",companyName);
        return sqlSession.selectList(sql(), map);
    }
}
