package org.smart4j.framework.bean;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;


/**
 * 封装请求信息
 */
public class Request {
    /**
     * 请求方法
     */
    private String requestMethod;

    /**
     * 请求路径
     */
    private String requesrPath;

    public Request(String requestMethod,String requesrPath){
        this.requestMethod = requestMethod;
        this.requesrPath = requesrPath;
    }

    public String getRequesrPath() {
        return requesrPath;
    }

    public String getRequestMethod() {
        return requestMethod;
    }

    @Override
    public int hashCode(){
        return HashCodeBuilder.reflectionHashCode(this);
    }

    @Override
    public boolean equals(Object obj){
        return EqualsBuilder.reflectionEquals(this,obj);
    }

}
