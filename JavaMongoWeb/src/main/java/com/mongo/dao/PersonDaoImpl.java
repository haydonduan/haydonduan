package com.mongo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Order;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import com.mongo.domain.Person;
import com.mongo.util.PageBean;
import com.mongodb.WriteResult;

@Service("personDao")
public class PersonDaoImpl implements PersonDao {

    @Autowired
    private MongoTemplate mongoTemplate;

    public List<Person> getPerson(int currentPage) {
        Query query = new Query();
        query.sort().on("_id", Order.DESCENDING);
        return mongoTemplate.find(query.limit(PageBean.PAGE_SIZE).skip((currentPage - 1) * PageBean.PAGE_SIZE), Person.class);
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

    public int updatePerson(Person p) {
        Query query = new Query(Criteria.where("_id").is(p.get_id()));
        Update update = new Update();
        update.set("name",p.getName());
        update.set("password",p.getPassword());
        WriteResult wr =  mongoTemplate.updateMulti(query, update, Person.class);
        return wr.getN();
    }

}
