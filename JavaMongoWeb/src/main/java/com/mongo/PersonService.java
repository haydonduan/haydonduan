package com.mongo;

import java.util.List;

public interface PersonService{
    List<Person> getPerson(int currentPage);
    Person findPersonByName(String name);
    void saveUser(Person p);
    int allUserCount();
}
