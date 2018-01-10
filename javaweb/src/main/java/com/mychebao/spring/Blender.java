/*
 * Copyright (C), 2014-2017, 江苏乐博国际投资发展有限公司
 * FileName: Blender.java
 * Author:   zhangdanji
 * Date:     2017年09月27日
 * Description:   
 */
package com.mychebao.spring;

/**
 * @author zhangdanji
 */
public class Blender {

    public String mix(String water,String fruit,String sugar){
        String juice = "这是一杯由液体:" + water + "\n 水果:" + fruit + "\n 糖量:" + sugar + "\n 组成的果汁";
        return juice;
    }
}
