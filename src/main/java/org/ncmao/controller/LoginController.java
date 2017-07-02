package org.ncmao.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController(value = "/login")
public class LoginController {



    @RequestMapping(value = "/", method = GET)
    public String login(){
        return "success";
    }


}
