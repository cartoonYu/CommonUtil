package org.redis.demo.controller;

import com.gitee.easyopen.annotation.Api;
import com.gitee.easyopen.annotation.ApiService;
import com.gitee.easyopen.doc.annotation.ApiDoc;
import com.gitee.easyopen.doc.annotation.ApiDocMethod;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.core.RedisTemplate;
import javax.annotation.Resource;

/**
 * @author cartoon
 * @description
 */
@ApiService
@ApiDoc(value = "api测试", order = 1)
public class ApiTestController {

    private static final Logger log = LoggerFactory.getLogger(TextController.class);

    @Resource
    private RedisTemplate<String, Object> redisTemplate;

    @Api(name = "textAddString", version = "1.0")
    @ApiDocMethod(description = "插入 String 测试", resultClass = String.class)
    public String textAddString(){
        redisTemplate.opsForValue().set("account", "aaaaa");
        log.info("get data: {}", redisTemplate.opsForValue().get("account").toString());
        return redisTemplate.opsForValue().get("account").toString();
    }
}
