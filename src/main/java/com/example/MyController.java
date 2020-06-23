package com.example;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {
    @GetMapping("/getInfo")
    public String getInfo() {
        POJO pojo = new POJO();


        return "this is test-ltw pojo.testService = " + pojo.testService;
    }
}
