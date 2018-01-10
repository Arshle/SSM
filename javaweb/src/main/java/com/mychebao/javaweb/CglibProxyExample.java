/*
 * Copyright (C), 2014-2017, 江苏乐博国际投资发展有限公司
 * FileName: CglibProxyExample.java
 * Author:   zhangdanji
 * Date:     2017年09月22日
 * Description:   
 */
package com.mychebao.javaweb;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;
import java.lang.reflect.Method;

/**
 * @author zhangdanji
 */
public class CglibProxyExample implements MethodInterceptor{

    public Object getProxy(Class cls){
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(cls);
        enhancer.setCallback(this);
        return enhancer.create();
    }

    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("调用前");
        Object result = methodProxy.invokeSuper(o, objects);
        System.out.println("调用后");
        return result;
    }

    public static void main(String[] args) {
        CglibProxyExample example = new CglibProxyExample();
        ReflectServiceImpl ref = (ReflectServiceImpl)example.getProxy(ReflectServiceImpl.class);
        ref.sayHello("zhangdanji");
    }
}
