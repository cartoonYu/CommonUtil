package org.rabbitmq.demo.config;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author cartoon
 * @description
 * @date 2020/4/28 10:04
 */
@Configuration
public class DelaySenderConfig {

    private static final String exchangeName = "text_exchange";

    @Bean
    DirectExchange textDirectExchange(){
        return (DirectExchange) ExchangeBuilder.directExchange(exchangeName).build();
    }

    @Bean
    Queue delayTextQueue() {
        return QueueBuilder.durable(MqNames.delay_queue_name)
                .build();
    }

    @Bean
    Binding dlxTextBinding(Queue delayTextQueue, DirectExchange textDirectExchange) {
        return BindingBuilder.bind(delayTextQueue)
                .to(textDirectExchange)
                .with(MqNames.delay_queue_name);
    }

    @Bean
    Queue delayTextQueuePerMessageTTL(){
        return QueueBuilder.durable(MqNames.delay_queue_ttl_name)
                .withArgument("x-dead-letter-exchange", exchangeName)
                .withArgument("x-dead-letter-routing-key", MqNames.delay_queue_name)
                .build();
    }
}
