/*
 * Copyright (C), 2014-2017, 江苏乐博国际投资发展有限公司
 * FileName: ReflectEntity.java
 * Author:   zhangdanji
 * Date:     2017年09月22日
 * Description:   
 */
package com.mychebao.javaweb;

import java.lang.reflect.InvocationTargetException;

/**
 * @author zhangdanji
 */
public class ReflectEntity {

    private String name;

    public ReflectEntity(String name){
        this.name = name;
    }

    public void sayHello(){
        System.err.println("Hello " + name);
    }

    public static ReflectEntity getInstance(){
        ReflectEntity object = null;
        try {
            object = (ReflectEntity)Class.forName("com.mychebao.javaweb.ReflectEntity").getConstructor(String.class).newInstance("zhangdanji");
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return object;
    }

    public static void main(String[] args) {
        ReflectEntity entity = getInstance();
        entity.sayHello();
    }
}
