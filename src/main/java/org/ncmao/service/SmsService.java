package org.ncmao.service;


import org.springframework.stereotype.Service;

import java.io.InputStream;

@Service
public class SmsService {

    private String endpoint = "http://oss-cn-hangzhou.aliyuncs.com";
    private String accessKeyId = "LTAIIdHuAJDt4Dpn";
    private String accessKeySecret = "pZZGlA2TgV4HuyTXrpucR9BRpNO1S3";

    public void validate(String phoneNumber) {
        String key = "sms_limit".concat(phoneNumber);
    }


    public void uploadFile(InputStream inputStream) {
        System.out.println();
    }
}
