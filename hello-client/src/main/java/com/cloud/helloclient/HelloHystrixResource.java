package com.cloud.helloclient;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("restHystrix/hello/client")
public class HelloHystrixResource {

    @Autowired
    RestTemplate restTemplate;

    private String HELLO_SERVER_URL = "http://hello-server/rest/hello/server";

    @HystrixCommand(fallbackMethod = "fallback")
    @GetMapping
    public String hello() {
        return restTemplate.getForObject(HELLO_SERVER_URL, String.class);
    }

    public String fallback(Throwable hystrixCommand) {
        return "Fall Back Hello world";
    }
}
