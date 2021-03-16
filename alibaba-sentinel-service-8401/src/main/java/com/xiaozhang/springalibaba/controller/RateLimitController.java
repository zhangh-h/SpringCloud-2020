package com.xiaozhang.springalibaba.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.xiaozhang.springalibaba.handle.CustomerBlockHandler;
import com.xiaozhang.springalibaba.sevice.OrderFeignService;
import com.xiaozhang.springcloud.entities.CommonResult;
import com.xiaozhang.springcloud.entities.Payment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @auther: ZhangH
 * @date: 2021/3/11 14:52
 * @version: 1.0
 */
@RestController
public class RateLimitController {

    public static final String PAYMENT_URL = "http://nacos-payment-provider";

    @Resource
    private RestTemplate restTemplate;

    @Resource
    private OrderFeignService orderFeignService;

    @GetMapping(value = "/byResource")
    @SentinelResource(value = "byResource", blockHandler = "handlerException")
    public CommonResult byResource() {
        return new CommonResult(200, "按资源名称限流测试OK", new Payment(2021L, "serial001"));
    }

    public CommonResult handlerException(BlockException e) {
        return new CommonResult(444, e.getClass().getCanonicalName() + "\t" + "服务不可用");
    }

    @GetMapping(value = "/byUrl")
    @SentinelResource(value = "byUrl")
    public CommonResult byUrl() {
        return new CommonResult(200, "按Url限流测试OK", new Payment(2021L, "serial002"));
    }

    @GetMapping(value = "/rateLimit/customerBlockHandler")
    @SentinelResource(value = "customerBlockHandler" , blockHandlerClass = CustomerBlockHandler.class, blockHandler = "handlerException1")
    public CommonResult customerBlockHandler() {
        return new CommonResult(200, "按客户自定义", new Payment(2021L, "serial003"));
    }

    @RequestMapping(value = "/consumer/fallback/{id}")
    //@SentinelResource(value = "fallbackHandler" , blockHandlerClass = CustomerBlockHandler.class, blockHandler = "handlerException1",fallback = "handlerFallback")
    @SentinelResource(value = "fallbackHandler" , blockHandlerClass = CustomerBlockHandler.class, blockHandler = "handlerException3")
    public String fallbackHandler(@PathVariable("id") Long id){
        if(id == 4){
            throw  new IllegalArgumentException("IllegalArgumentException  非法参数异常");
        }else if(id == null){
            throw new NullPointerException("NullPointerException   空指针异常");
        }
        return restTemplate.getForObject(PAYMENT_URL + "/payment/nacos/" + id, String.class);
    }

    @RequestMapping(value = "/consumer/feign/{id}")
    @SentinelResource(value = "feignHandler" , blockHandlerClass = CustomerBlockHandler.class, blockHandler = "handlerException3")
    public String feignHandler(@PathVariable("id") Integer id){
        return orderFeignService.getPayment(id);
    }

    public String handlerFallback(@PathVariable Long id, Throwable e){
        return "兜底异常   handlerFallback" + e;
    }

}
