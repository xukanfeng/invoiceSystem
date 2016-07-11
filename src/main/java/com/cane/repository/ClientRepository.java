package com.cane.repository;

import com.cane.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by xu_kanfeng on 16/1/22.
 */
@Repository // 添加注解
public interface ClientRepository extends JpaRepository<UserEntity, Integer>{
    @Modifying      // 说明该方法是修改操作
    @Transactional  // 说明该方法是事务性操作
    // 定义查询
    // @Param注解用于提取参数
    @Query("update ClientEntity cl set cl.hasDrawed=:qHasDrawed where cl.phoneNumber=:qPhoneNumber")
    public void updateClient(@Param("qHasDrawed") String hasDrawed);

//    @Query("select ClientEntity from ClientEntity where phoneNumber=:phoneNumber")
//    public void getClientByPhone(@Param("phoneNumber") String phoneNumber);
}