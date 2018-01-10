/*
 * Copyright (C), 2014-2017, 江苏乐博国际投资发展有限公司
 * FileName: JdkProxyExample.java
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
public class JdkProxyExample implements InvocationHandler {

    private Object target = null;

    public Object bind(Object target){
        this.target = target;
        return Proxy.newProxyInstance(target.getClass().getClassLoader(),target.getClass().getInterfaces(),this);
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("进入代理逻辑方法");
        System.out.println("在调度真实对象之前的服务");
        Object obj = method.invoke(target, args);
        System.out.println("在调度真实对象之后的服务");
        return obj;
    }

    public static void main(String[] args) {
        JdkProxyExample example = new JdkProxyExample();
        HelloWorld proxy = (HelloWorld) example.bind(new HelloWorldImpl());
        proxy.sayHelloWorld();
    }
}
