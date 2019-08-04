package org.smart4j.framework.aop.demo;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class GreetingAspect {

    @Around("@annotation(aop.demo.Tag)")
    public Object around(ProceedingJoinPoint pjp) throws Throwable{
        before();
        Object result = pjp.proceed();
        after();
        return result;
    }

    public void before(){
        System.out.println("Before");
    }

    public void after(){
        System.out.println("After");
    }

}
