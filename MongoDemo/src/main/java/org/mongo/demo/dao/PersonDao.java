package org.mongo.demo.dao;

import org.mongo.demo.model.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author cartoon
 * @description
 * @date 2020/7/20 11:01
 */
@Component
public class PersonDao {

    private static final Logger log = LoggerFactory.getLogger(PersonDao.class);

    @Resource
    private MongoTemplate mongoTemplate;

    public void save(Person person){
        Person res = mongoTemplate.save(person);
        log.info("insert person, name: {}, age: {}", res.getName(), res.getAge());
    }

    public List<Person> findAll(){
        List<Person> resList = mongoTemplate.findAll(Person.class);
        resList.forEach(person -> {
            log.info("get data, name: {}, age: {}", person.getName(), person.getAge());
        });
        return resList;
    }

    /**
     * update age by name
     * @param person
     */
    public void update(Person person){
        Query query = new Query(Criteria.where("name").is(person.getName()));
        Update update = new Update();
        update.set("age", person.getAge());
        log.info("update data, condition: {}, data: {}", person.getName(), person.getAge());
        mongoTemplate.updateFirst(query, update, Person.class);
    }

    /**
     * delete by name
     * @param person
     */
    public void delete(Person person){
        Query query = new Query(Criteria.where("name").is(person.getName()));
        long count = mongoTemplate.remove(query, Person.class).getDeletedCount();
        log.info("delete count: {}", count);
    }
}
