package com.xiaozhang.springalibaba.sevice;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @auther: ZhangH
 * @date: 2021/3/16 15:24
 * @version: 1.0
 */
@Service
@FeignClient(value = "nacos-payment-provider")
public interface OrderFeignService {

    @GetMapping(value = "payment/nacos/{id}")
    String getPayment(@PathVariable("id") Integer id) ;
}
