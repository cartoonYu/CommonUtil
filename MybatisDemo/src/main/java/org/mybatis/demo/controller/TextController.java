package org.mybatis.demo.controller;

import com.gitee.easyopen.annotation.Api;
import com.gitee.easyopen.annotation.ApiService;
import com.gitee.easyopen.doc.annotation.ApiDoc;
import com.gitee.easyopen.doc.annotation.ApiDocMethod;
import org.mybatis.demo.bean.UserInfo;
import org.mybatis.demo.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author cartoon
 * @description
 */
@ApiService
@ApiDoc(value = "测试", order = 1)
public class TextController {

    @Autowired
    private UserDao userDao;

    @Api(name = "text", version = "1.0")
    @ApiDocMethod(description = "测试", resultClass = String.class)
    public String text(){
        return "text";
    }

    @Api(name = "getUser", version = "1.0")
    @ApiDocMethod(description = "获取用户信息", resultClass = UserInfo.class)
    public UserInfo getUser(){
        return userDao.selectByPrimaryKey(222L);
    }
}
