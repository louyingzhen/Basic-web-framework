package org.smart4j.framework.proxy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.smart4j.framework.annotation.Aspect;
import org.smart4j.framework.annotation.Controller;

import java.lang.reflect.Member;
import java.lang.reflect.Method;

/**
 * 拦截Controller所有方法
 */

@Aspect(Controller.class)
public class ControllerAspect extends AspectProxy {

    public static final Logger LOGGER = LoggerFactory.getLogger(ControllerAspect.class);

    private long begin;

    @Override
    public void before(Class<?> cls, Method method,Object[] params) throws Throwable{
        LOGGER.debug(String.format("time:%dms",System.currentTimeMillis()-begin));
        LOGGER.debug("--------------------end-------------------");
    }

}
