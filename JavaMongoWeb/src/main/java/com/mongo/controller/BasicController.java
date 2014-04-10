package com.mongo.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;

import com.mongo.domain.Person;

public abstract class BasicController {
    
    @Autowired
    private HttpServletRequest request;
    
    public Person getPerson(){
        return (Person)request.getSession(true).getAttribute("sessionUser");
    }
    public void setSessionPerson(Person person){
        request.getSession(true).setAttribute("sessionUser",person);
    }
}
