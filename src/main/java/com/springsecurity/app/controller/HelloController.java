package com.springsecurity.app.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @GetMapping("/hello")
    public String checkBasicAuth() {
        return "Basic Auth Working Fine.";
    }

    @GetMapping("/bye")
    public String getMessage() {
        return "message is u did";
    }
}
