package com.xiaozhang.springcloud.controller;

import com.xiaozhang.springcloud.service.IMessageProvider;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @auther: ZhangH
 * @date: 2021/2/25 9:46
 * @version: 1.0
 */
@RestController
public class SendMessageController {

    @Resource
    private IMessageProvider messageProvider;

    @GetMapping(path = "/sendMessage")
    public String sendMessage() {
        return messageProvider.send();
    }
}
