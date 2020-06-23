package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.scheduling.annotation.Async;

@Configurable
public class POJO {
    @Autowired
    public TestService testService;

    @Async
    public void print() {
        System.out.println("POJO print thread " + Thread.currentThread().toString());
    }

    @Profile
    public void print1() {
        System.out.println("POJO print1");
    }
}
