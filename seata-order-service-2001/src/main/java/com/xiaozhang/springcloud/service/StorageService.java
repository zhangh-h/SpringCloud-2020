package com.xiaozhang.springcloud.service;

import com.xiaozhang.springcloud.entity.CommentResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * ClassName: StorageService <br/>
 *
 * @author xiao张<br />
 * @date: 2021/3/25 16:53
 * @version: 1.0
 * <p>
 * Description: <br/>
 */
@FeignClient(value = "seata-storage-service")
public interface StorageService {
    @PostMapping(path = "/storage/decrease")
    CommentResult decrease (@RequestParam("productId") Long productId, @RequestParam("count") Integer count);

}
