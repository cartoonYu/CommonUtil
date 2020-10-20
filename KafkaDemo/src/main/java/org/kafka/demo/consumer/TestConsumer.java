package org.kafka.demo.consumer;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

/**
 * @author cartoon
 * @description
 * @date 2020/3/24 8:24 PM
 */
@Component
public class TestConsumer {

    private static final Logger log = LoggerFactory.getLogger(TestConsumer.class);

    @KafkaListener(topics = "test", id = "test", containerFactory = "kafkaListenerContainerFactory")
    public void listen(List<ConsumerRecord<?, ?>> records, Acknowledgment ack){
        ack.acknowledge();
        for (ConsumerRecord<?, ?> record : records) {
            Optional<?> kafkaMessage = Optional.ofNullable(record.value());
            if (kafkaMessage.isPresent()) {
                Object msg = kafkaMessage.get();
                log.info("receive data: {}", msg.toString());
            }
        }
    }
}
