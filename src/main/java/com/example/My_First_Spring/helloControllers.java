package com.example.My_First_Spring;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class helloControllers {

    @GetMapping("/hello")
    public String hello(){
        return "Olá";
    }
}
