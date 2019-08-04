package org.smart4j.framework.aop;

public class ApologyImpl implements Apology {
    @Override
    public void saySorry(String name) {
        System.out.println("Sorry!" + name);
    }
}
