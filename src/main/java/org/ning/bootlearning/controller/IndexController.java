package org.ning.bootlearning.controller;


import org.ning.bootlearning.domain.User;
import org.ning.bootlearning.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping(value = "/")
public class IndexController {

    @Autowired
    private UserService userService;

    @RequestMapping(method = RequestMethod.GET)
    public String showIndex(Map<String,Object> model){
        model.put("user", new User("ncmao", 22));
        return "index";
    }



    @RequestMapping(value = "/user")
    public User getToken(@RequestParam String name) {
        User user = new User();
        user.setName(name);
        return userService.save(user);
    }
}
