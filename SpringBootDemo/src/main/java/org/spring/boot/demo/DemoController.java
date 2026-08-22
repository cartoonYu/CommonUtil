package org.spring.boot.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author cartoon
 * @since 2026/08/08 11:38
 */
@RestController
public class DemoController {

    @GetMapping("demo")
    public String demo() {
        return "Spring Boot Demo";
    }
}
