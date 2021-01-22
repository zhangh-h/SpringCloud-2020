package com.xiaozhang.springcloud.service.impl;

import com.xiaozhang.springcloud.service.PaymentService;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @auther: ZhangH
 * @date: 2021/1/21 11:10
 * @version: 1.0
 */
@Service
public class PaymentServiceImpl implements PaymentService {
    @Override
    public String payment_OK(Integer id) {
        return Thread.currentThread().getName()+ "paymeny_OK " + id + "\t " + "O(∩_∩)O哈哈~";
    }

    @Override
    public String payment_TimeOut(Integer id) {
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return Thread.currentThread().getName() + "payment_TimeOut " + id + "\t " + "/(ㄒoㄒ)/~~";
    }
}
