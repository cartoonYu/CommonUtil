package org.rabbitmq.demo.controller;

import com.gitee.easyopen.annotation.Api;
import com.gitee.easyopen.annotation.ApiService;
import com.gitee.easyopen.doc.annotation.ApiDoc;
import com.gitee.easyopen.doc.annotation.ApiDocMethod;
import org.rabbitmq.demo.config.MqNames;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Message;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

/**
 * @author cartoon
 * @description
 */
@ApiService
@ApiDoc(value = "api测试", order = 1)
public class ApiTestController {

    private static final Logger log = LoggerFactory.getLogger(TextController.class);

    @Autowired
    private AmqpTemplate amqpTemplate;

    @Api(name = "textInTimeSend", version = "1.0")
    @ApiDocMethod(description = "普通消息发送", resultClass = String.class)
    public Boolean textInTimeSend(){
        String sendData = "inTimeData";
        amqpTemplate.convertAndSend(MqNames.in_time_queue_name, sendData);
        log.info("send data: {}, send time: {}", sendData, new Date());
        return true;
    }

    @Api(name = "textDelaySend", version = "1.0")
    @ApiDocMethod(description = "延时消息发送", resultClass = String.class)
    public Boolean textDelaySend(){
        String sendData = "text data";
        amqpTemplate.convertAndSend(MqNames.delay_queue_ttl_name, sendData, (Message message)->{
            message.getMessageProperties().setExpiration("2000");
            return message;
        });
        log.info("send data: {}, send time: {}", sendData, new Date());
        return true;
    }
}
