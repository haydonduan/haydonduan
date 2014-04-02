package com.mongo.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.mongo.domain.Person;
import com.mongo.service.PersonService;
import com.mongo.util.PageBean;

@Controller
public class PersonController {
    @Autowired
    private HttpServletRequest request;
    @Autowired
    private PersonService personService;
    
    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public ModelAndView find(ModelMap model){
        ModelAndView mav = new ModelAndView("index");
        return mav;
    }
    
    @RequestMapping(value = "/check", method = RequestMethod.POST)
    public ModelAndView check(ModelMap model,String name,String password){
        Person person = personService.findPersonByName(name);
        HttpSession session = request.getSession();
        session.setAttribute("sessionUser", person);
        ModelAndView mav = new ModelAndView();
       if(person == null){
           mav.setViewName("index");
       }else{
           if(person.getPassword().equals(password)){
               mav.setViewName("success");
               detail(mav,1);
           }else{
               mav.setViewName("index");
           }
       }
        return mav;
    }
    @RequestMapping(value = "/detail/{currentPage}", method = RequestMethod.GET)
    public ModelAndView detail(ModelAndView mav,@PathVariable("currentPage") int currentPage){
        HttpSession session = request.getSession(false);
        if(session == null){
            mav.setViewName("index");
            return mav;
        }
        mav.setViewName("success");
        mav.addObject("personList", personService.getPerson(currentPage));
        mav.addObject("pageBean",new PageBean(personService.allUserCount(), currentPage));
        mav.addObject("person", (Person)session.getAttribute("sessionUser"));
        return mav;
    }
    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public ModelAndView register(ModelMap model){
        ModelAndView mav = new ModelAndView();
        mav.setViewName("register");
        return mav;
    }
    
    @RequestMapping(value = "/doregister", method = RequestMethod.POST)
    public ModelAndView register(ModelMap model,Person p){
        ModelAndView mav = new ModelAndView();
        if("".equals(p.getName().trim()) || "".equals(p.getPassword().trim())){
            mav.setViewName("register");
        }else{
            personService.saveUser(p);
            mav.setViewName("index");
        }
        return mav;
    }
}
