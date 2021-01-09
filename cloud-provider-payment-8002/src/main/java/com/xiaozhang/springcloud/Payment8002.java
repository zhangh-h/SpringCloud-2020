package com.xiaozhang.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @auther: ZhangH
 * @date: 2020/12/25 15:35
 * @version: 1.0
 */
@SpringBootApplication
@EnableEurekaClient
public class Payment8002 {
    public static void main(String[] args) {
            SpringApplication.run(Payment8002.class,args);
    }
}
