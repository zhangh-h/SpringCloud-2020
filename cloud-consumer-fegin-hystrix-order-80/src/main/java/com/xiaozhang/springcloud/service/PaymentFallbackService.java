package com.xiaozhang.springcloud.service;

import org.springframework.stereotype.Component;

/**
 * @auther: ZhangH
 * @date: 2021/1/26 16:27
 * @version: 1.0
 */
@Component
public class PaymentFallbackService implements PaymentHystrixService {
    @Override
    public String Payment_OK(Integer id) {
        return "-------PaymentFallbackService fall back Payment_OK, /(ㄒoㄒ)/~~";
    }

    @Override
    public String Payment_TimeOut(Integer id) {
        return "-------PaymentFallbackService fall back Payment_TimeOut, /(ㄒoㄒ)/~~";
    }
}
