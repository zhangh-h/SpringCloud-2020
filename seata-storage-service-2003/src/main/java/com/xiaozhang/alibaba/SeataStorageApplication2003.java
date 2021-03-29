package com.xiaozhang.alibaba;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * ClassName: SeataStorageApplication2003 <br/>
 *
 * @author xiao张<br />
 * @date: 2021/3/25 17:54
 * @version: 1.0
 * <p>
 * Description: <br/>
 */
@SpringBootApplication
@FeignClient
@EnableDiscoveryClient
public class SeataStorageApplication2003 {
    public static void main(String[] args) {
        SpringApplication.run(SeataStorageApplication2003.class, args);
    }
}
