package org.nacos.configuration.controller;

import com.alibaba.nacos.api.config.annotation.NacosValue;
import com.gitee.easyopen.annotation.Api;
import com.gitee.easyopen.annotation.ApiService;
import com.gitee.easyopen.doc.annotation.ApiDoc;
import com.gitee.easyopen.doc.annotation.ApiDocMethod;

/**
 * @author cartoon
 * @description
 */
@ApiService
@ApiDoc(value = "测试", order = 1)
public class TextController {

    @NacosValue(value = "${useLocalCache:false}", autoRefreshed = true)
    private String useLocalCache;

    @Api(name = "text", version = "1.0")
    @ApiDocMethod(description = "测试", resultClass = String.class)
    public String text(){
        return "nacos configuration";
    }

    @Api(name = "get", version = "1.0")
    @ApiDocMethod(description = "模拟获取", resultClass = String.class)
    public String get(){
        return useLocalCache;
    }
}
