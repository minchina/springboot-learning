package org.ning.bootlearning.controller;


import org.ning.bootlearning.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping(value = "/")
public class IndexController {



    @RequestMapping(method = RequestMethod.GET)
    public String showIndex(Map<String,Object> model){
        model.put("user", new User("ncmao", 22));
        return "index";
    }



    @RequestMapping(value = "/user")
    public String getToken(@RequestParam String name) {
        return name;
    }
}
