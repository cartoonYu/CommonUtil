package org.rabbitmq.demo.consumer;

import org.rabbitmq.demo.config.MqNames;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author cartoon
 * @description
 * @date 2020/4/28 10:30
 */
@Component
public class InTimeConsumer {

    private static Logger log = LoggerFactory.getLogger(InTimeConsumer.class);

    @RabbitListener(queuesToDeclare = @Queue(MqNames.in_time_queue_name))
    @RabbitHandler
    public void receive(String data){
        String receiveData = data;
        log.info("receive: {}, date: {}", receiveData, new Date());
    }
}
