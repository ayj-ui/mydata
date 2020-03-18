package com.example.mydata.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
public class t {
    @RequestMapping("/a")
    public String a(){
        return "admin";
    }
}
