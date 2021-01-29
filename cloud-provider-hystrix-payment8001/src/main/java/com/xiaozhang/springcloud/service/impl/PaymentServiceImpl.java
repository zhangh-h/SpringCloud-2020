package com.xiaozhang.springcloud.service.impl;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.xiaozhang.springcloud.service.PaymentService;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

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
    @HystrixCommand(fallbackMethod = "paymentTimeOutHystrix", commandProperties = {
         @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "5000"),   //服务降级，超时时间1s
         @HystrixProperty(name = "circuitBreaker.enabled", value = "true"),  //开启断路器
         @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"),  //请求次数
         @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "10000"),  //时间窗口
         @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "10")  //失败率达到阈值跳闸
    })
    public String payment_TimeOut(Integer id) {
        System.out.println("*********熔断执行===");
        if(id < 0){
            throw new RuntimeException("*********id不能为负数");
        }
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return Thread.currentThread().getName() + "payment_TimeOut " + id + "\t " + "/(ㄒoㄒ)/~~";
    }

    public String paymentTimeOutHystrix(@PathVariable("id") Integer id){
        return "支付方  ：8001 ， 系统繁忙，请等待后在重试或者自己运行出错，check自己， /(ㄒoㄒ)/~~";
    }
}
