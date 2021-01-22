package com.xiaozhang.springcloud.controller;

import com.xiaozhang.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @auther: ZhangH
 * @date: 2021/1/21 11:19
 * @version: 1.0
 */
@RestController
@Slf4j
public class PaymentController {

    @Resource
    PaymentService paymentService;

    @GetMapping(value = "payment/hystrix/payment_OK/{id}")
    public String payment_Ok(@PathVariable("id") Integer id){
        String result = paymentService.payment_OK(id);
        log.info("**********result: " + result);
        return result;
    }

    @GetMapping(value = "payment/hystrix/payment_TimeOut/{id}")
    public String payment_TimeOut(@PathVariable("id") Integer id){
        String result = paymentService.payment_TimeOut(id);
        log.info("************result: " + result);
        return result;
    }

}
