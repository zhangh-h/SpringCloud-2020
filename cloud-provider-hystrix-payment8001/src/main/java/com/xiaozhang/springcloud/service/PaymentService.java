package com.xiaozhang.springcloud.service;

/**
 * @auther: ZhangH
 * @date: 2021/1/21 11:09
 * @version: 1.0
 */
public interface PaymentService {

    String payment_OK(Integer id);

    String payment_TimeOut(Integer id);
}
