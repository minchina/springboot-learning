package org.ncmao.controller;


import org.ncmao.service.SmsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ncmao
 */
@RestController
@RequestMapping("/sms")
public class SendSmsController {


    @Autowired
    private SmsService smsService;

    @RequestMapping(value = "/send/{phoneNumber}", method = RequestMethod.GET)
    public void sendSms(@PathVariable String phoneNumber){
        smsService.validate(phoneNumber);

    }
}
