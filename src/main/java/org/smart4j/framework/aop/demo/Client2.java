package org.smart4j.framework.aop.demo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Client2 {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("aop/demo/spring.xml");
        Hello hello = (Hello)context.getBean("HelloImpl");
        hello.say("Jack");

        Apology apology = (Apology) hello;
        apology.saySorry("Jack");
    }
}
