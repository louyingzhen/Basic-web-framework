package org.smart4j.framework.aop.demo;

import org.springframework.stereotype.Component;

@Component
public class HelloImpl implements Hello {

    @Tag
    @Override
    public void say(String name) {

        System.out.println("Hello" + name);

       // throw new RuntimeException("Error");
    }
}
