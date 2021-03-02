package com.xiaozhang.springalibaba;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @auther: ZhangH
 * @date: 2021/3/1 17:18
 * @version: 1.0
 */
@SpringBootApplication
@EnableDiscoveryClient
public class PaymentApplication9002 {
    public static void main(String[] args) {
        SpringApplication.run(PaymentApplication9002.class, args);
    }
}
