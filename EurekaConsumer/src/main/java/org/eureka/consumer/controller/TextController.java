package org.eureka.consumer.controller;

import com.gitee.easyopen.annotation.Api;
import com.gitee.easyopen.annotation.ApiService;
import com.gitee.easyopen.doc.annotation.ApiDoc;
import com.gitee.easyopen.doc.annotation.ApiDocMethod;
import org.eureka.consumer.util.EurekaProducerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.annotation.Resource;

/**
 * @author cartoon
 * @description
 * @date 2020/4/25 18:15
 */
@ApiService
@ApiDoc(value = "测试", order = 1)
public class TextController {

    private static Logger log = LoggerFactory.getLogger(TextController.class);

    @Resource
    private EurekaProducerService eurekaProducerService;

    @Api(name = "text", version = "1.0")
    @ApiDocMethod(description = "测试", resultClass = String.class)
    public String text(){
        return "mysql demo";
    }

    @Api(name = "simulation_call", version = "1.0")
    @ApiDocMethod(description = "模拟调用", resultClass = String.class)
    public String simulationCall() throws Exception{
        return eurekaProducerService.simulationCall();
    }
}
