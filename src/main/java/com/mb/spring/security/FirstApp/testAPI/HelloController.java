package com.mb.spring.security.FirstApp.testAPI;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/hello")
    public String helloApp(){
        return "hello from First App";
    }

    @GetMapping("/bye")
    public String byeApp(){
        return "bye from First App";
    }
}
