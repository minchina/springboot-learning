package org.ncmao.controller;


import org.ncmao.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@Controller
@RequestMapping("/login")
public class LoginController {


    @Autowired
    private LoginService loginService;

    @RequestMapping(value = "/", method = GET)
    @ResponseBody
    public String login(){
        return "success";
    }

    @RequestMapping(value = "/oauth/github/callback", method = GET)
    public String loginByAuth2(@RequestParam String code){
        String token = loginService.getToken(code);
        return "redirect:http://localhost:8080/callback?token=" + token;

    }

}
