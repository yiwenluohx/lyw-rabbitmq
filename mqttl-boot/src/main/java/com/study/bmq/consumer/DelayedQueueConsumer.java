package com.study.bmq.consumer;

import com.study.bmq.config.DelayedQueueConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @Author: luohx
 * @Description: 消费者   基于插件的延时消费
 * @Date: 2021/7/19 15:57
 */
@Slf4j
@Component
public class DelayedQueueConsumer {
    @RabbitListener(queues = DelayedQueueConfig.DELAYED_QUEUE_NAME)
    public void receiveDelayedQueue(Message message) {
        String msg = new String(message.getBody());
        log.info("当前时间:{},收到延时队列的消息:{}", new Date().toString(), msg);
    }
}
