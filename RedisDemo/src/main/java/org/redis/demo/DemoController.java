package org.redis.demo;

import jakarta.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

/**
 * @author cartoon
 * @since 2026/08/08 11:38
 */
@RestController
public class DemoController {

    private static final Logger log = LoggerFactory.getLogger(DemoController.class);
    @Resource
    private RedisService redisService;

    @PostMapping("/{key}")
    public void set(
            @PathVariable String key,
            @RequestParam String value) {
        redisService.set(key, value);
        log.info("set key:{},value:{}", key, redisService.get(key));
    }
}
