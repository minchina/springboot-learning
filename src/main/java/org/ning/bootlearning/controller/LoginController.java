package org.ning.bootlearning.controller;

import org.ning.bootlearning.domain.LoginData;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
public class LoginController {

    @RequestMapping(value = "/login", method = POST)
    public LoginData getToken(@RequestBody LoginData loginData) {
        loginData.setToken("123456");
        return loginData;
    }
}
