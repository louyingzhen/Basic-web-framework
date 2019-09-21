package org.smart4j.framework.plugin.security;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.smart4j.framework.annotation.Aspect;
import org.smart4j.framework.annotation.Controller;
import org.smart4j.framework.exception.AuthzException;
import org.smart4j.framework.proxy.AspectProxy;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

/**
 * 授权注解切面
 */
@Aspect(Controller.class)
public class AuthzAnnotationAspect extends AspectProxy {
    /**
     * 定义一个基于授权功能的注解类数组
     */
    private static final Class[] ANNOTATION_CLASS_ARRAY = {
            User.class
    };

    @Override
    public void before(Class<?> cls, Method method, Object[] params) throws Throwable {
        //从目标类和目标方法中获取相应的注解
        Annotation annotation = getAnnoation(cls, method);
        if (annotation != null) {
            //判断授权注解的类型
            Class<?> annotationType = annotation.annotationType();
            if(annotationType.equals(User.class)){
                handleUser();
            }
        }
    }

    private Annotation getAnnoation(Class<?> cls,Method method){
        //遍历所有的授权注解
        for(Class<? extends Annotation> annotationClass : ANNOTATION_CLASS_ARRAY){
            //首先判断目标方法上是否带有授权注解
            if(method.isAnnotationPresent(annotationClass)){
                return method.getAnnotation(annotationClass);
            }
            //然后判断目标类上是否带有授权注解
            if(cls.isAnnotationPresent(annotationClass)){
                return cls.getAnnotation(annotationClass);
            }
        }
        //若目标方法与目标类上均未带有授权注解，则返回空对象
        return null;
    }

    private void handleUser(){
        Subject currentUser = SecurityUtils.getSubject();
        PrincipalCollection principals = currentUser.getPrincipals();
        if(principals==null||principals.isEmpty()){
            throw new AuthzException("当前用户尚未登录");
        }

    }

}
