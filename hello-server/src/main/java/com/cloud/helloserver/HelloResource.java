package com.cloud.helloserver;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest")
public class HelloResource {

    @GetMapping("/server")
    public String defaultHello() {
        return "Hello FROM CLIENT!";
    }

    @GetMapping("/hello")
    public String hello() {
        return "Hello From SERVER!";
    }
}
