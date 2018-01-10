/*
 * Copyright (C), 2014-2017, 江苏乐博国际投资发展有限公司
 * FileName: JuiceMaker2.java
 * Author:   zhangdanji
 * Date:     2017年09月27日
 * Description:   
 */
package com.mychebao.spring;

/**
 * @author zhangdanji
 */
public class JuiceMaker2 {
    private String beverageShop;
    private Source source;

    public String makeJuice(){
        String juice = "这是一杯由" + beverageShop +"饮品店提供的" + source.getSize() + source.getSugar() + source.getFruit();
        return juice;
    }

    public String getBeverageShop() {
        return beverageShop;
    }

    public void setBeverageShop(String beverageShop) {
        this.beverageShop = beverageShop;
    }

    public Source getSource() {
        return source;
    }

    public void setSource(Source source) {
        this.source = source;
    }
}
