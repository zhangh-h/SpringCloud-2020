package com.xiaozhang.springcloud.service;

import com.xiaozhang.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Param;

/**
 * @auther: ZhangH
 * @date: 2020/12/25 16:10
 * @version: 1.0
 */
public interface PaymentService {

    int create(Payment payment);

    Payment getPaymentById(@Param("id") Long id);
}
