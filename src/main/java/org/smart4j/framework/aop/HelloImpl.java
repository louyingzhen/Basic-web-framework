package org.smart4j.framework.aop;

import org.smart4j.framework.aop.demo.Tag;
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
