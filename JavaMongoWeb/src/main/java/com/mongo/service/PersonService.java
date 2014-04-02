package com.mongo.service;

import java.util.List;

import com.mongo.domain.Person;

public interface PersonService{
    List<Person> getPerson(int currentPage);
    Person findPersonByName(String name);
    void saveUser(Person p);
    int allUserCount();
}
