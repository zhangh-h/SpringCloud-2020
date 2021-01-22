package com.xiaozhang.springcloud.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @auther: ZhangH
 * @date: 2021/1/21 16:13
 * @version: 1.0
 */
@Component
@FeignClient(value = "CLOUD-PAYMENT-HYSTRIX-SERVICE")
public interface PaymentHystrixService {

    @GetMapping(value = "payment/hystrix/payment_OK/{id}")
    String Payment_OK(@PathVariable("id") Integer id);

    @GetMapping(value = "payment/hystrix/payment_TimeOut/{id}")
    String Payment_TimeOut(@PathVariable("id") Integer id);
}
