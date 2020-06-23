package com.example;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class ProfilingAspect {
    @Around("methodsToBeProfiled()")
    public Object profile(ProceedingJoinPoint pjp) throws Throwable {
        long start = System.currentTimeMillis();

        Object obj = pjp.proceed();

        long cost = System.currentTimeMillis() - start;
        System.out.println("profile " + pjp.getSignature().toShortString() + " " + cost + "ms");

        return obj;
    }

    @Pointcut("execution(* *(..)) && @annotation(com.example.Profile)")
    public void methodsToBeProfiled() {
    }
}
