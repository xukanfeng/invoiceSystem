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

    public void setTaxcontrolSettingDefault(TaxcontrolSettingEntity taxcontrolSetting){
        sqlSession.update(sql(), taxcontrolSetting);
    }

    public void addTaxcontrolSetting(TaxcontrolSettingEntity taxcontrolSetting) {sqlSession.insert(sql(), taxcontrolSetting);}

    public void deleteTaxcontrolSetting(String shopName) {
        Map<String,String> map = new HashMap<String, String>();
        map.put("shopName",shopName);
        sqlSession.delete(sql(), map);}
}
