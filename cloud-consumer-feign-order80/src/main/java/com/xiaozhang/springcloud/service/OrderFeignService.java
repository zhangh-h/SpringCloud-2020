package com.xiaozhang.springcloud.service;

import com.xiaozhang.springcloud.entities.CommonResult;
import com.xiaozhang.springcloud.entities.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @auther: ZhangH
 * @date: 2021/1/13 9:22
 * @version: 1.0
 */
@Component
@FeignClient(value = "cloud-payment-service")
public interface OrderFeignService {

    @GetMapping(value = "/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id);

    @GetMapping(value = "/payment/feign/timeout")
    public String paymentFeignTimeout();
}
