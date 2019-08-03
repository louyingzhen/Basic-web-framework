package org.smart4j.framework.aop;

public class HelloImpl implements Hello {

    @Override
    public void say(String name) {

        System.out.println("Hello" + name);

        throw new RuntimeException("Error");
    }
}
