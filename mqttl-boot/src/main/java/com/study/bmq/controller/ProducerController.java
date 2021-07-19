package com.study.bmq.controller;

import com.study.bmq.config.ConfirmConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;

/**
 * @Author: luohx
 * @Description: 发布确认高级 - 生产消息
 * @Date: 2021/7/19 17:19
 */
@RestController
@RequestMapping("/confirm")
@Slf4j
public class ProducerController {

    @Autowired
    private RabbitTemplate rabbitTemplate;

//    @Autowired
//    private MyCallBack myCallBack;

    //依赖注入 rabbitTemplate 之后再设置它的回调对象
//    @PostConstruct
//    public void init() {
//        rabbitTemplate.setConfirmCallback(myCallBack);
//    }

    @GetMapping("/sendMessage/{message}")
    public void sendMessage(@PathVariable String message) {
        //指定消息 id 为 1
//        CorrelationData correlationData1 = new CorrelationData("1");
        String routingKey = "key1";
        rabbitTemplate.convertAndSend(ConfirmConfig.CONFIRM_EXCHANGE_NAME, routingKey, message);
        log.info("发送消息内容:{}", message);
    }

}
