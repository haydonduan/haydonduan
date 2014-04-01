package com.mongo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;
@Service("personService")
public class PersonServiceImpl implements PersonService {

    @Autowired
    private MongoTemplate mongoTemplate;
    public List<Person> getPerson() {
       return mongoTemplate.find(new Query().limit(3), Person.class);
    }

}
