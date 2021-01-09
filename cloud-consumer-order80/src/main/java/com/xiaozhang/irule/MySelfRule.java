package com.xiaozhang.irule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @auther: ZhangH
 * @date: 2021/1/8 10:54
 * @version: 1.0
 * desc:
 *   自定义负载算法，自定义配置类不能放在启动类的目录或者子类下面，否则无法生效
 */
@Configuration
@Slf4j
public class MySelfRule {
    @Bean
    public IRule myRule(){
        //自定义为随机负载
        log.info("myRule初始化完成！");
        return new RandomRule();
    }

}
