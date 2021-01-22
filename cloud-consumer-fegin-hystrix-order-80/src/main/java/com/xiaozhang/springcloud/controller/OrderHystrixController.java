package com.xiaozhang.springcloud.controller;

import com.xiaozhang.springcloud.service.PaymentHystrixService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @auther: ZhangH
 * @date: 2021/1/21 16:15
 * @version: 1.0
 */
@RestController
@Slf4j
@RequestMapping(value = "/consumer")
public class OrderHystrixController {

    @Resource
    PaymentHystrixService paymentHystrixService;

    @GetMapping("payment/hystrix/payment_OK/{id}")
    public String Order_OK(@PathVariable("id") Integer id){
        return paymentHystrixService.Payment_OK(id);
    }

    @GetMapping("payment/hystrix/payment_TimeOut/{id}")
    public String Order_TimeOut(@PathVariable("id") Integer id){
        return paymentHystrixService.Payment_TimeOut(id);
    }
}
