package org.spring.boot.demo;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author cartoon.yu
 * @since 2026/08/08 11:43
 */
@SpringBootApplication
@EnableDubbo
public class DubboProducerDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DubboProducerDemoApplication.class, args);
    }
}
