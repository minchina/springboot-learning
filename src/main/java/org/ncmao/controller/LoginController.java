package org.ncmao.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController(value = "/login")
public class LoginController {



    @RequestMapping(method = POST)
    public String login(){
        return "success";
    }
}
