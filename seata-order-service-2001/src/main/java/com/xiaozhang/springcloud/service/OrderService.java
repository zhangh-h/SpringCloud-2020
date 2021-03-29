package com.xiaozhang.springcloud.service;

import com.xiaozhang.springcloud.entity.Order;

/**
 * ClassName: OrderService <br/>
 *
 * @author xiao张<br />
 * @date: 2021/3/25 16:13
 * @version: 1.0
 * <p>
 * Description: <br/>
 */
public interface OrderService {
    void create(Order order);
}
