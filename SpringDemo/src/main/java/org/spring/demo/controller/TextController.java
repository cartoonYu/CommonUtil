package org.spring.demo.controller;

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

    @Api(name = "text", version = "1.0")
    @ApiDocMethod(description = "测试", resultClass = String.class)
    public String text(){
        return "spring";
    }
}
