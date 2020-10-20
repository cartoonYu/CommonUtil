package org.mongo.demo.controller;

import com.gitee.easyopen.annotation.Api;
import com.gitee.easyopen.annotation.ApiService;
import com.gitee.easyopen.doc.annotation.ApiDoc;
import com.gitee.easyopen.doc.annotation.ApiDocMethod;
import org.mongo.demo.dao.PersonDao;
import org.mongo.demo.model.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author cartoon
 * @description
 */
@ApiService
@ApiDoc(value = "api测试", order = 1)
public class ApiTestController {

    private static final Logger log = LoggerFactory.getLogger(ApiTestController.class);

    @Resource
    private PersonDao personDao;

    @Api(name = "findAll", version = "1.0")
    @ApiDocMethod(description = "搜索全部记录", resultClass = List.class)
    public List<Person> findAll(){
        List<Person> personList = personDao.findAll();
        personList.forEach(person -> {
            log.info("name: {}, age: {}", person.getName(), person.getAge());
        });
        return personList;
    }

    @Api(name = "insertData", version = "1.0")
    @ApiDocMethod(description = "插入数据", resultClass = String.class)
    public String insert(){
        Person person = new Person();
        person.setName("bbb");
        person.setAge(1111);
        personDao.save(person);
        return "insert";
    }

    @Api(name = "updateData", version = "1.0")
    @ApiDocMethod(description = "更新数据", resultClass = String.class)
    public String update(){
        Person person = new Person();
        person.setName("bbb");
        person.setAge(2222);
        personDao.update(person);
        return "update";
    }

    @Api(name = "deleteData", version = "1.0")
    @ApiDocMethod(description = "删除数据", resultClass = String.class)
    public String delete(){
        Person person = new Person();
        person.setName("aaa");
        person.setAge(1111);
        personDao.delete(person);
        return "delete";
    }
}
