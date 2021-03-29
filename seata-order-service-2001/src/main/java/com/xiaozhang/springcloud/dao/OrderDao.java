package com.xiaozhang.springcloud.dao;

import com.xiaozhang.springcloud.entity.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * ClassName: OrderDao <br/>
 *
 * @author xiao张<br />
 * @date: 2021/3/25 17:23
 * @version: 1.0
 * <p>
 * Description: <br/>
 */
@Mapper
public interface OrderDao {
    /**
     * 
     * @author zhangh
     * @date 2021/3/25 17:46
     * @param order 
     * @return void
     * @Description: 创建订单
     */
    void create(Order order);

    void update(@Param("userId") Long userId, @Param("status") Integer status);
}
