package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AdviceMode;
import org.springframework.context.annotation.EnableLoadTimeWeaving;
import org.springframework.context.annotation.aspectj.EnableSpringConfigured;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableLoadTimeWeaving
@EnableSpringConfigured
@EnableAsync(mode = AdviceMode.ASPECTJ)
public class AppApplication {
    public static void main(String[] args) {
        // 初始化 spring context
        ApplicationContext context = SpringApplication.run(AppApplication.class, args);

        // 创建 POJO，此时 TestService 会被注入到 POJO 中
        POJO pojo = new POJO();
        System.out.println("inject bean " + pojo.testService);

        TestService testService = context.getBean(TestService.class);
        // 正常调用切面
        testService.asyncPrint();
        // 切面的类内调用
        testService.print();
        // 非 spring 管理的类切面调用，spring 定义的切面
        pojo.print();
        // 非 spring 管理的类切面调用，自定义的切面
        pojo.print1();
    }
}
