package com.xiaozhang.springalibaba.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @auther: ZhangH
 * @date: 2021/3/12 15:35
 * @version: 1.0
 */
@Configuration
@Slf4j
public class ApplicationContextConfig {
    @Bean
    @LoadBalanced
    public RestTemplate restTemplate(){
        log.info("RestTemplete初始化完成========");
        return new RestTemplate();
    }
}
