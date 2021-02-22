package com.xiaozhang.springcloud.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.Date;

/**
 * @auther: ZhangH
 * @date: 2021/2/3 10:17
 * @version: 1.0
 */
@Component
@Slf4j
public class MyLogGatewayFilter implements GlobalFilter, Ordered {

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {

        log.info("*************come  in  MyLogGatewayFilter: " + new Date() + "\t" + Thread.currentThread().getName());

        String username = exchange.getRequest().getQueryParams().getFirst("username");

        if(username == null){
            log.info("********用户名为null，非法用户，/(ㄒoㄒ)/~~");
            exchange.getResponse().setStatusCode(HttpStatus.NOT_ACCEPTABLE);
            return exchange.getResponse().setComplete();
        }

        return chain.filter(exchange);
    }

    /**
     *
     * @author zhangh
     * @date 2021/2/3 10:20
     * @param
     * @return int
     * @Description: Talk is cheap,show me the code
     * chain链执行等级，数值越小，越先执行
     */
    @Override
    public int getOrder() {
        return 0;
    }
}
