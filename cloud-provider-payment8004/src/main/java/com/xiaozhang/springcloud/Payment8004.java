package com.xiaozhang.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @auther: ZhangH
 * @date: 2021/1/5 14:39
 * @version: 1.0
 */
@SpringBootApplication
@EnableDiscoveryClient  //该注解用于向使用consul zookeeper作为注册中心的时候发现服务
public class Payment8004 {
    public static void main(String[] args) {
        SpringApplication.run(Payment8004.class,args);
    }
}
