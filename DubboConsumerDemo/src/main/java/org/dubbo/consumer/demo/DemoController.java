package org.dubbo.consumer.demo;

import org.apache.dubbo.config.annotation.DubboReference;
import org.apache.dubbo.config.annotation.DubboService;
import org.common.DubboDemoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author cartoon
 * @since 2026/08/08 11:38
 */
@RestController
public class DemoController {

    @DubboReference
    private DubboDemoService dubboDemoService;

    @GetMapping("demo")
    public String demo() {
        return dubboDemoService.say();
    }
}
