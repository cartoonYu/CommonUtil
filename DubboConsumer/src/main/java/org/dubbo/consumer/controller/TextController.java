package org.dubbo.consumer.controller;

import com.gitee.easyopen.annotation.Api;
import com.gitee.easyopen.annotation.ApiService;
import com.gitee.easyopen.doc.annotation.ApiDoc;
import com.gitee.easyopen.doc.annotation.ApiDocMethod;
import org.apache.dubbo.config.annotation.DubboReference;
import org.common.DubboService;

/**
 * @author cartoon
 * @description
 * @date 2020/6/29 16:07
 */
@ApiService
@ApiDoc(value = "测试", order = 1)
public class TextController {

    @DubboReference
    private DubboService dubboService;

    @Api(name = "text", version = "1.0")
    @ApiDocMethod(description = "测试", resultClass = String.class)
    public String text(){
        return "dubbo consumer";
    }

    @Api(name = "simulation.call", version = "1.0")
    @ApiDocMethod(description = "模拟调用", resultClass = String.class)
    public String say(){
        return dubboService.say();
    }
}
