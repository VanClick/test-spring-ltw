package com.example;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class TestService {

    @Async
    @Profile
    public void asyncPrint() {
        System.out.println("TestService print thread " + Thread.currentThread().toString());
    }

    public void print() {
        asyncPrint();
    }
}
