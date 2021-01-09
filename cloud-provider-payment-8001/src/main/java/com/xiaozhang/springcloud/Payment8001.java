package com.xiaozhang.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @auther: ZhangH
 * @date: 2020/12/25 15:35
 * @version: 1.0
 */
@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient  //服务发现  用于发现服务eureka  zookeeper   consul ，后面可以直接使用这个注解。
public class Payment8001 {
    public static void main(String[] args) {
            SpringApplication.run(Payment8001.class,args);
    }
}
