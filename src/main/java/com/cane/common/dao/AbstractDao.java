package com.cane.common.dao;

import org.mybatis.spring.SqlSessionTemplate;

import javax.annotation.Resource;

/**
 * Created by xu_kanfeng on 16/1/23.
 */
public class AbstractDao {
    @Resource
    protected SqlSessionTemplate sqlSession;

    protected String sql() {
        String sqlId = new RuntimeException().getStackTrace()[1].getMethodName();
        return getClass().getSimpleName() + '.' + sqlId;
    }
}
