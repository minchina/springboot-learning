package org.ning.bootlearning.controller;


import org.ning.bootlearning.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;

@Controller
@RequestMapping(value = "/")
public class IndexController {


    @RequestMapping(method = RequestMethod.GET)
    public String showIndex(Map<String,Object> model){
        model.put("user", new User("ncmao", 22));
        return "index";
    }



}
