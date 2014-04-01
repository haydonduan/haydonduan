package com.mongo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PersonController {
    @Autowired
    private PersonService perService;
    @RequestMapping(value = "/detail", method = RequestMethod.GET)
    public ModelAndView find(ModelMap model){
        List<Person> list = perService.getPerson();
        model.addAttribute("list", list);
        ModelAndView mav = new ModelAndView("index");
        mav.addObject("list", list);
        return mav;
    }
}
