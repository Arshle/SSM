/*
 * Copyright (C), 2014-2017, 江苏乐博国际投资发展有限公司
 * FileName: ProxyBeanUtil.java
 * Author:   zhangdanji
 * Date:     2017年09月27日
 * Description:   
 */
package com.mychebao.util;

import com.mychebao.interceptor.Interceptor;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author zhangdanji
 */
public class ProxyBeanUtil implements InvocationHandler {

    private Object obj;

    private Interceptor interceptor;

    public static Object getBean(Object obj,Interceptor interceptor){
        ProxyBeanUtil _this = new ProxyBeanUtil();
        _this.obj = obj;
        _this.interceptor = interceptor;
        return Proxy.newProxyInstance(obj.getClass().getClassLoader(), obj.getClass().getInterfaces(), _this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object retObj = null;
        boolean exceptionFlag = false;
        interceptor.before(obj);
        try {
            retObj = method.invoke(obj, args);
        } catch (Exception e) {
            exceptionFlag = true;
        } finally {
            interceptor.after(obj);
        }
        if(exceptionFlag){
            interceptor.afterThrowing(obj);
        }else{
            interceptor.afterReturning(obj);
        }
        return retObj;
    }
}
