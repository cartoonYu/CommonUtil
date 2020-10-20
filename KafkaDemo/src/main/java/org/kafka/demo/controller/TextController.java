package org.kafka.demo.controller;

import com.gitee.easyopen.annotation.Api;
import com.gitee.easyopen.annotation.ApiService;
import com.gitee.easyopen.doc.annotation.ApiDoc;
import com.gitee.easyopen.doc.annotation.ApiDocMethod;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;

/**
 * @author cartoon
 * @description
 * @date 2020/3/24 8:22 PM
 */
@ApiService
@ApiDoc(value = "测试", order = 1)
public class TextController {

    @Resource
    private KafkaTemplate kafkaTemplate;

    @Api(name = "text", version = "1.0")
    @ApiDocMethod(description = "测试", resultClass = String.class)
    public String text(){
        return "kafkaDemo";
    }

    @Api(name = "textSend", version = "1.0")
    @ApiDocMethod(description = "模拟发送", resultClass = Boolean.class)
    public Boolean send(){
        kafkaTemplate.send("test", "test data");
        return true;
    }

}
