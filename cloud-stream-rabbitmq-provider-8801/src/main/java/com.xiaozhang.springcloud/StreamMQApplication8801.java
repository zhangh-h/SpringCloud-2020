package com.xiaozhang.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @auther: ZhangH
 * @date: 2021/2/25 9:43
 * @version: 1.0
 */
@SpringBootApplication
@EnableDiscoveryClient
public class StreamMQApplication8801 {
    public static void main(String[] args) {
        SpringApplication.run(StreamMQApplication8801.class, args);
    }
}
