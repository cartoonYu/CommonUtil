package org.dubbo.producer.controller;

import com.gitee.easyopen.annotation.Api;
import com.gitee.easyopen.annotation.ApiService;
import com.gitee.easyopen.doc.annotation.ApiDoc;
import com.gitee.easyopen.doc.annotation.ApiDocMethod;
import org.common.DubboService;

import javax.annotation.Resource;

/**
 * @author cartoon
 * @description
 * @date 2020/6/29 16:07
 */
@ApiService
@ApiDoc(value = "测试", order = 1)
public class TextController {

    @Resource
    private DubboService dubboService;


    @Api(name = "text", version = "1.0")
    @ApiDocMethod(description = "测试", resultClass = String.class)
    public String text(){
        return "dubbo provider";
    }

    @Api(name = "provider.return", version = "1.0")
    @ApiDocMethod(description = "服务提供者返回", resultClass = String.class)
    public String providerReturn(){
        return dubboService.say();
    }
}
