package com.xiaozhang.springcloud.dao;

import com.xiaozhang.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @auther: ZhangH
 * @date: 2020/12/25 15:57
 * @version: 1.0
 */
@Mapper
public interface PaymentDao {
    /*
    * 基本CRUD操作
    * */
    int create(Payment payment);

    Payment getPaymentById(@Param("id") Long id);
}
