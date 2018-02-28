package com.cloud.helloclient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


@RestController
@RequestMapping("rest/hello/client")
public class HelloResource {

    @Autowired
    RestTemplate restTemplate;

    private String HELLO_SERVER_URL = "http://hello-server/rest/hello/server";

    @GetMapping
    public String hello() {
        return restTemplate.getForObject(HELLO_SERVER_URL, String.class);
    }


}
