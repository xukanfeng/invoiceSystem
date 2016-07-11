package com.cane.repository;

import com.cane.common.dao.AbstractDao;
import com.cane.model.ManagerEntity;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by xu_kanfeng on 16/1/24.
 */
@Repository
public class ManagerDao extends AbstractDao{
    public ManagerEntity getManagerByName(String name){
        Map<String,String> map = new HashMap<String, String>();
        map.put("name", name);
        return sqlSession.selectOne(sql(), map);
    }
}
