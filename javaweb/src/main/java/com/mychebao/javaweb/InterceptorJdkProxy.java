/*
 * Copyright (C), 2014-2017, 江苏乐博国际投资发展有限公司
 * FileName: InterceptorJdkProxy.java
 * Author:   zhangdanji
 * Date:     2017年09月22日
 * Description:   
 */
package com.mychebao.javaweb;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author zhangdanji
 */
public class InterceptorJdkProxy implements InvocationHandler {

    private Object target;
    private String interceptorClass;

    public InterceptorJdkProxy(Object target,String interceptorClass){
        this.target = target;
        this.interceptorClass = interceptorClass;
    }

    public static Object bind(Object target,String interceptorClass){
        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(),new InterceptorJdkProxy(target,interceptorClass) );
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if(interceptorClass == null){
            return method.invoke(target, args);
        }
        Object result = null;
        Interceptor interceptor = (Interceptor)Class.forName(interceptorClass).newInstance();
        if(interceptor.before(proxy,target,method,args)){
            result = method.invoke(target, args);
        }else{
            interceptor.around(proxy,target,method,args);
        }
        interceptor.after(proxy,target,method,args);
        return result;
    }

    public static void main(String[] args) {
        HelloWorld proxy = (HelloWorld) InterceptorJdkProxy.bind(new HelloWorldImpl(), "com.mychebao.javaweb.MyInterceptor");
        proxy.sayHelloWorld();
    }
}
