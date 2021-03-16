package com.xiaozhang.springalibaba.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/**
 * @auther: ZhangH
 * @date: 2021/3/4 17:03
 * @version: 1.0
 */
@RestController
@Slf4j
public class FlowLimitController {

    @GetMapping(value = "/testA")
    public String testA(){
        return "~~~~testA~~~~~~";
    }

    @GetMapping(value = "/testB")
    public String testB(){
        return "~~~~testB~~~~~~";
    }

    @GetMapping(value = "/testC")
    public String testC(){
        try {
            TimeUnit.SECONDS.sleep(1);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        log.info("~~~~testC~~~~~~");
        return "~~~~testC~~~~~~";
    }

    @GetMapping(value = "/testD/{param}")
    public String testD(@PathVariable(value = "param") int param){
        log.info("~~~~testD异常比~~~~~~");
        int a = 10 /param;
        return "~~~~~~testD异常比~~~~~~";
    }

}
