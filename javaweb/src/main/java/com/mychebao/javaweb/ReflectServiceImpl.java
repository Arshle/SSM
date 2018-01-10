/*
 * Copyright (C), 2014-2017, 江苏乐博国际投资发展有限公司
 * FileName: ReflectServiceImpl.java
 * Author:   zhangdanji
 * Date:     2017年09月22日
 * Description:   
 */
package com.mychebao.javaweb;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author zhangdanji
 */
public class ReflectServiceImpl {

    public void sayHello(String name){
        System.err.println("Hello " + name);
    }

    public static ReflectServiceImpl getInstance(){
        ReflectServiceImpl object = null;
        try {
            object = (ReflectServiceImpl)Class.forName("com.mychebao.javaweb.ReflectServiceImpl").newInstance();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
        return object;
    }

    public String getName(String name){
        return name;
    }

    public static Object reflectMethod(){
        Object returnObj = null;
        ReflectServiceImpl ref = new ReflectServiceImpl();
        try {
            Method method = ReflectServiceImpl.class.getMethod("getName", String.class);
            returnObj = method.invoke(ref,"zhangdanji");
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return returnObj;
    }

    public static void main(String[] args) {
        System.out.println(reflectMethod());
    }
}
