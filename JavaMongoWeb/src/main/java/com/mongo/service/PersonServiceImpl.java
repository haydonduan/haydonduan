package com.mongo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mongo.dao.PersonDao;
import com.mongo.domain.Person;

@Service("personService")
public class PersonServiceImpl implements PersonService {

    @Autowired
    private PersonDao personDao;

    public List<Person> getPerson(int currentPage) {
        return personDao.getPerson(currentPage);
    }

    public void saveUser(Person p) {
        personDao.saveUser(p);
    }

    public Person findPersonByName(String name) {
        return personDao.findPersonByName(name);
    }

    public int allUserCount() {
        return personDao.allUserCount();
    }

}
