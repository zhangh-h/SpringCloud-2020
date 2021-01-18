package com.xiaozhang.springcloud.controller;

import com.xiaozhang.springcloud.entities.CommonResult;
import com.xiaozhang.springcloud.entities.Payment;
import com.xiaozhang.springcloud.service.OrderFeignService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @auther: ZhangH
 * @date: 2021/1/13 9:22
 * @version: 1.0
 */
@RestController
@Slf4j
@RequestMapping("/consumer")
public class OrderFeignController {

    @Resource
    private OrderFeignService orderFeignService;


    @GetMapping("/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id){
        return orderFeignService.getPaymentById(id);
    }

    @GetMapping(value = "/payment/feign/timeout")
    public String paymentFeignTimeout(){
        return orderFeignService.paymentFeignTimeout();
    }
}
