package com.imooc.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController extends BaseController {

    @RequestMapping("/")
    public String index() {
        System.out.println(123);
        return "Greetings from Spring Boot!";
    }
    @RequestMapping("/hello")
    public String hello() {
        System.out.println(123);
        return "Greetings from Spring Boot!";
    }
}