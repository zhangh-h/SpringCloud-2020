package com.xiaozhang.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @auther: ZhangH
 * @date: 2021/2/23 17:15
 * @version: 1.0
 */
@EnableEurekaClient
@SpringBootApplication
public class ConfigClientApplication3366 {
    public static void main(String[] args) {
        SpringApplication.run(ConfigClientApplication3366.class, args);
    }
}
