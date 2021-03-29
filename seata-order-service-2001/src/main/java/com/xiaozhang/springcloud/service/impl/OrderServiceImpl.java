package com.xiaozhang.springcloud.service.impl;

import com.xiaozhang.springcloud.dao.OrderDao;
import com.xiaozhang.springcloud.entity.Order;
import com.xiaozhang.springcloud.service.AccountService;
import com.xiaozhang.springcloud.service.OrderService;
import com.xiaozhang.springcloud.service.StorageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * ClassName: OrderServiceImpl <br/>
 *
 * @author xiao张<br />
 * @date: 2021/3/25 16:14
 * @version: 1.0
 * <p>
 * Description: <br/>
 */
@Slf4j
@Service
public class OrderServiceImpl implements OrderService {

    @Resource
    private OrderDao orderDao;
    @Resource
    private StorageService storageService;
    @Resource
    private AccountService accountService;


    /**
     * 创建订单->调用库存服务扣减库存->调用账户服务扣减余额->修改订单状态
     * */
    @Override
    public void create(Order order) {
        log.info("-------->开始创建订单");
        orderDao.create(order);

        log.info("订单微服务开始调用库存，做扣减Count");
        storageService.decrease(order.getProductId(), order.getCount());
        log.info("订单微服务开始调用库存，做扣减end");

        log.info("订单微服务开始调用账户，做扣减Money");
        accountService.decrease(order.getUserId(), order.getMoney());
        log.info("订单微服务开始调用账户，做扣减end");

        log.info("--------->修改订单状态");
        orderDao.update(order.getUserId(),0);
        log.info("--------->修改订单状态end");

        log.info("-------->下订单结束了，圆满完成O(∩_∩)O");
    }
}
