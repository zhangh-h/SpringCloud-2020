package com.xiaozhang.springcloud.service;

import com.xiaozhang.springcloud.entity.CommentResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;

/**
 * ClassName: AccountService <br/>
 *
 * @author xiao张<br />
 * @date: 2021/3/25 16:53
 * @version: 1.0
 * <p>
 * Description: <br/>
 */
@FeignClient(value = "seata-storage-service")
public interface AccountService {
    @PostMapping("/account/decrease")
    CommentResult decrease(@RequestParam("userId") Long userId, @RequestParam("money")BigDecimal money);
}
