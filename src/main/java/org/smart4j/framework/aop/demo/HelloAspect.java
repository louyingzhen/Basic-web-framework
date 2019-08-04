package org.smart4j.framework.aop.demo;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.DeclareParents;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class HelloAspect {

    @DeclareParents(value = "aop.HelloImpl",defaultImpl = ApologyImpl.class)
    private Apology apology;

}
