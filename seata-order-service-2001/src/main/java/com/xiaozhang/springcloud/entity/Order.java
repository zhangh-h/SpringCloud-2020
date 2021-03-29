package com.xiaozhang.springcloud.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * ClassName: Order <br/>
 *
 * @author xiao张<br />
 * @date: 2021/3/25 16:20
 * @version: 1.0
 * <p>
 * Description: <br/>
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {
    private Long id;
    private Long userId;
    private Long productId;
    private Integer count;
    private BigDecimal money;
    private Integer status;
}
