package com.xiaozhang.springcloud.controller;

import com.xiaozhang.springcloud.entity.CommentResult;
import com.xiaozhang.springcloud.entity.Order;
import com.xiaozhang.springcloud.service.OrderService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * ClassName: OrderController <br/>
 *
 * @author xiao张<br />
 * @date: 2021/3/25 16:09
 * @version: 1.0
 * <p>
 * Description: <br/>
 */
@RestController
public class OrderController {
    @Resource
    OrderService orderService;

    @RequestMapping(path = "/order/create")
    public CommentResult create(Order order){
        orderService.create(order);
        return new CommentResult("200", "create success!!!!!");
    }
}
