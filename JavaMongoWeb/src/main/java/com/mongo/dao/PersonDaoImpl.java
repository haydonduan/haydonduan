package com.mongo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import com.mongo.domain.Person;
import com.mongo.util.PageBean;

@Service("personDao")
public class PersonDaoImpl implements PersonDao {

    @Autowired
    private MongoTemplate mongoTemplate;

    public List<Person> getPerson(int currentPage) {
        return mongoTemplate.find(new Query().limit(PageBean.PAGE_SIZE).skip((currentPage - 1) * PageBean.PAGE_SIZE), Person.class);
    }

    public void saveUser(Person p) {
        mongoTemplate.save(p);
    }

    public Person findPersonByName(String name) {
        Query q = new Query(Criteria.where("name").is(name));
        Person p = mongoTemplate.findOne(q, Person.class);
        return p;
    }

    public int allUserCount() {
        return mongoTemplate.findAll(Person.class).size();
    }

}
