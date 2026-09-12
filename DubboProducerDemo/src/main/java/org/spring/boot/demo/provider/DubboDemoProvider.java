package org.spring.boot.demo.provider;

import jakarta.annotation.PostConstruct;
import org.apache.dubbo.config.annotation.DubboService;
import org.common.DubboDemoService;

/**
 * @author cartoon.yu
 * @since 2026/09/11 08:22
 */
@DubboService
public class DubboDemoProvider implements DubboDemoService {

    @Override
    public String say() {
        return "DubboDemoProvider";
    }

    @PostConstruct
    public void init() {
        System.out.println("DubboDemoProvider initialized");
    }
}
