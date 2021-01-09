package com.xiaozhang.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @auther: ZhangH
 * @date: 2021/1/6 16:43
 * @version: 1.0
 */
@RestController
@Slf4j
public class PaymentController {
    @Value("${server.port}")
    private String serverPort;

    @RequestMapping(value= "/payment/consul")
    public String paymentConsul(){
        return "springcloud with conusl: " + serverPort + "\t " + UUID.randomUUID().toString();
    }
}
