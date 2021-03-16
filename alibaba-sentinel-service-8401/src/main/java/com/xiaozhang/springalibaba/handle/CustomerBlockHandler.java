package com.xiaozhang.springalibaba.handle;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.xiaozhang.springcloud.entities.CommonResult;

/**
 * @auther: ZhangH
 * @date: 2021/3/11 20:41
 * @version: 1.0
 */
public class CustomerBlockHandler {

    public static CommonResult handlerException1(BlockException e){
        return  new CommonResult(4444, "按客户自定义，global handlerException ----- 1");
    }

    public static CommonResult handlerException2(BlockException e){
        return  new CommonResult(4444, "按客户自定义，global handlerException ----- 2");
    }

    public static String handlerException3(BlockException e){
        return "按客户自定义，global handlerException ----- 3";
    }
}
