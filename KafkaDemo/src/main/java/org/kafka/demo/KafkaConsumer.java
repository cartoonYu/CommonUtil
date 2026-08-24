package org.kafka.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

/**
 * @author cartoon.yu
 * @since 2026/08/24 22:34
 */
@Component
public class KafkaConsumer {

    private static final Logger log = LoggerFactory.getLogger(KafkaConsumer.class);

    @KafkaListener(
            topics = "demo-topic",
            groupId = "demo-group"
    )
    public void consume(String message) {
        log.info("receive message:{}", message);
    }
}
