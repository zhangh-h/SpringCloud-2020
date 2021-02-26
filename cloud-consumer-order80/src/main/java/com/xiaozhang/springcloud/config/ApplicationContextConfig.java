package com.xiaozhang.springcloud.config;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @auther: ZhangH
 * @date: 2020/12/30 14:39
 * @version: 1.0
 */
@Configuration
@Slf4j
public class ApplicationContextConfig {

    private static final Logger logger= LoggerFactory.getLogger(ApplicationContextConfig.class);

    @Bean("restTemplate")
    @LoadBalanced   //负载均衡策略
    public RestTemplate getRestTemplate(){
        logger.info("RestTemplate初始化完成！");
        return new RestTemplate();
    }

}
