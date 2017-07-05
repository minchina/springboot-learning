package org.ncmao.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Service
public class LoginService {


    @Value("${github.token.url}")
    private String url;

    @Value("${github.userInfo.url}")
    private String userInfoUrl;

    @Value("${github.client_id}")
    private String clientId;

    @Value("${github.client_secrect}")
    private String clientSecret;

    @Autowired
    private RestTemplate restTemplate;

    public String getToken(String code) {
        Map<String, String> params = new HashMap<>();
        params.put("client_id", clientId);
        params.put("client_secret", clientSecret);
        params.put("code", code);
        ResponseEntity<String> stringResponseEntity = restTemplate.postForEntity(url, params, String.class);
        return parseGithubResponse(stringResponseEntity.getBody());
    }

    private String parseGithubResponse(String response) {
        String[] reponseValues = response.split("&");
        return reponseValues[0].split("=")[1];
    }

}
