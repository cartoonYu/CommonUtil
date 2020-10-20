package org.jpa.demo.controller;

import com.gitee.easyopen.annotation.Api;
import com.gitee.easyopen.annotation.ApiService;
import com.gitee.easyopen.doc.annotation.ApiDoc;
import com.gitee.easyopen.doc.annotation.ApiDocMethod;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author cartoon
 * @description
 * @date 2020/4/25 18:15
 */
@ApiService
@ApiDoc(value = "测试", order = 1)
public class TextController {

    private static Logger log = LoggerFactory.getLogger(TextController.class);

    @Api(name = "text", version = "1.0")
    @ApiDocMethod(description = "测试", resultClass = String.class)
    public String text(){
        return "mysql demo";
    }
}
