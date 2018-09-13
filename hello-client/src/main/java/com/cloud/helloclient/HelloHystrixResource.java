package com.cloud.helloclient;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.apache.commons.lang.math.RandomUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("rest")
public class HelloHystrixResource {

    @Autowired
    RestTemplate restTemplate;

    private String HELLO_SERVER_URL = "http://hello-server/rest/server";

    @HystrixCommand(fallbackMethod = "fallBackHello", commandKey = "hello", groupKey = "hello")
    @GetMapping("/hello")
    public String getHello() {
        if (RandomUtils.nextBoolean()) {
            throw new RuntimeException("Failed!");
        }

        return restTemplate.getForObject(HELLO_SERVER_URL, String.class) + "including client";
    }

    public String fallBackHello() {
        return "Default Hello World!";
    }

}
