package org.mongo.demo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.io.Serializable;

/**
 * @author cartoon
 * @description
 * @date 2020/7/20 10:57
 */
@Document(collection = "Person")
public class Person implements Serializable {

    @Id
    @Field(value = "_id")
    private String id;

    @Field(value = "name")
    private String name;

    @Field(value = "age")
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
