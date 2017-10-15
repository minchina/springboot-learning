package org.ncmao.service;


import org.springframework.stereotype.Service;

@Service
public class SmsService {


    public void validate(String phoneNumber) {
        String key = "sms_limit".concat(phoneNumber);
    }
}
