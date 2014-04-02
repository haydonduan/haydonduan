package com.mongo.dao;

import java.util.List;

import com.mongo.domain.Person;

public interface PersonDao{
    List<Person> getPerson(int currentPage);
    Person findPersonByName(String name);
    void saveUser(Person p);
    int allUserCount();
}
