package com.xiaozhang.springcloud.loadblancer;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

/**
 * @auther: ZhangH
 * @date: 2021/1/9 14:56
 * @version: 1.0
 */
public interface LoadBalancer {

    ServiceInstance instance(List<ServiceInstance> serviceInstances);

}
