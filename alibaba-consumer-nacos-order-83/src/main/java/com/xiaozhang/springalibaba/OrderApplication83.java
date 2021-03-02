package com.xiaozhang.springalibaba;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @auther: ZhangH
 * @date: 2021/3/2 9:30
 * @version: 1.0
 */
@SpringBootApplication
@EnableDiscoveryClient
public class OrderApplication83 {
    public static void main(String[] args) {
        SpringApplication.run(OrderApplication83.class, args);
    }
}
