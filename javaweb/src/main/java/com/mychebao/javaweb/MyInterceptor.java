/*
 * Copyright (C), 2014-2017, 江苏乐博国际投资发展有限公司
 * FileName: MyInterceptor.java
 * Author:   zhangdanji
 * Date:     2017年09月22日
 * Description:   
 */
package com.mychebao.javaweb;

import java.lang.reflect.Method;

/**
 * @author zhangdanji
 */
public class MyInterceptor implements Interceptor {

    public boolean before(Object proxy, Object target, Method method, Object[] args) {
        System.err.println("反射方法前逻辑");
        return false;
    }

    public void around(Object proxy, Object target, Method method, Object[] args) {
        System.err.println("取代了被代理对象的方法");
    }

    public void after(Object proxy, Object target, Method method, Object[] args) {
        System.err.println("反射方法后逻辑");
    }
}
