package com.xiaozhang.springcloud.loadblancer.impl;

import com.xiaozhang.springcloud.loadblancer.LoadBalancer;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @auther: ZhangH
 * @date: 2021/1/9 14:58
 * @version: 1.0
 */
@Component
public class MyLoadBalancer implements LoadBalancer {

    private AtomicInteger atomicInteger = new AtomicInteger(0);

    public final int getAndIncrement(){
        int current;
        int next;

        do{
            current = this.atomicInteger.get();
            next = current >= 2147483647 ? 0 : current+1;
        }while(!this.atomicInteger.compareAndSet(current, next));
        System.out.println("***********访问次数：  " + next);
        return next;
    }

    
    /**
     * 
     * @author zhangh
     * @date 2021/1/9 17:47
     * @param serviceInstances 
     * @return org.springframework.cloud.client.ServiceInstance
     * @Description: 负载均衡算法
     *
     * rest接口第几次请求数 % 服务器集群总数量 = 实际调用服务器的位置下标，每次服务器重新启动后rest接口计数从1开始
     */
    @Override
    public ServiceInstance instance(List<ServiceInstance> serviceInstances) {

        int index = getAndIncrement() % serviceInstances.size();
        return serviceInstances.get(index);
    }
}
