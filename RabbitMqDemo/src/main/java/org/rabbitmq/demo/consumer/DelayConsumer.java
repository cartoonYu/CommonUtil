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
 * @date 2020/4/28 09:45
 */
@Component
public class DelayConsumer {

    private static Logger log = LoggerFactory.getLogger(DelayConsumer.class);

    @RabbitListener(queuesToDeclare = @Queue(MqNames.delay_queue_name))
    @RabbitHandler
    public void receive(String data){
        String receiveData = data;
        log.info("receive: {}, date: {}", receiveData, new Date());
    }
}
