package org.smart4j.framework.aop;


import org.springframework.aop.framework.ProxyFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Client {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("aop/demo/spring.xml");
        //转型为目标类，而并非他的Greeting接口
        HelloImpl helloImpl = (HelloImpl) context.getBean("helloProxy");
        helloImpl.say("Jacl");

        //将目标类强制向上转型为Apology接口(这是引入增强给我们带来的特性，也就是"接口动态实现"功能)
        Apology apology = (Apology) helloImpl;
        apology.saySorry("Jack");

    }

}
