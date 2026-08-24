package org.kafka.demo;

import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author cartoon
 * @since 2026/08/08 11:38
 */
@RestController
public class DemoController {

    @Resource
    private KafkaProducer kafkaProducer;

    @GetMapping("send")
    public void demo(String msg) {
        kafkaProducer.send(msg);
    }
}
