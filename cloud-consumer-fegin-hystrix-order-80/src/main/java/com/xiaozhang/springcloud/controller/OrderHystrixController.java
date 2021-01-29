package com.xiaozhang.springcloud.controller;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.xiaozhang.springcloud.service.PaymentHystrixService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
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
@DefaultProperties(defaultFallback = "paymentTimeOutHystrixGlobal", commandProperties = {
        @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "5000")})     //兜底全局异常处理
public class OrderHystrixController {

    @Value("${server.port}")
    String port;

    @Resource
    PaymentHystrixService paymentHystrixService;

    @GetMapping("payment/hystrix/payment_OK/{id}")
    public String Order_OK(@PathVariable("id") Integer id){
        return paymentHystrixService.Payment_OK(id);
    }

    @GetMapping("payment/hystrix/payment_TimeOut/{id}")
    @HystrixCommand(fallbackMethod = "paymentTimeOutHystrix", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "3000")})
   // @HystrixCommand
    public String Order_TimeOut(@PathVariable("id") Integer id){
        return paymentHystrixService.Payment_TimeOut(id);
    }

    public String paymentTimeOutHystrix(@PathVariable("id") Integer id){
        return "消费者  ：" + port + "， 支付方系统繁忙，请等待后在重试或者自己运行出错，check自己， /(ㄒoㄒ)/~~";
    }

    public String paymentTimeOutHystrixGlobal(){
        return "Glooble 全局异常处理， /(ㄒoㄒ)/~~";
    }
}
