/*
 * Copyright (C), 2014-2017, 江苏乐博国际投资发展有限公司
 * FileName: SpringUtil.java
 * Author:   zhangdanji
 * Date:     2017年09月27日
 * Description:   
 */
package com.mychebao.util;

import org.apache.ibatis.io.Resources;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * @author zhangdanji
 */
public class SpringUtil {

    private static ConcurrentMap<String, Object> applicationContext = new ConcurrentHashMap<>();

    static {
        try {
            SAXReader reader = new SAXReader();
            Document document = reader.read(Resources.getResourceAsStream("spring/applicationContext.xml"));
            Element root = document.getRootElement();
            for(Object obj : root.elements("bean")){
                Element bean = null;
                if(Element.class.isInstance(obj)){
                    bean = Element.class.cast(obj);
                    String beanId = bean.attributeValue("id");
                    String className = bean.attributeValue("class");
                    Object entity = Class.forName(className).newInstance();
                    for(Object propertyObj : bean.elements("property")){
                        Element property = null;
                        if(Element.class.isInstance(propertyObj)){
                            property = Element.class.cast(propertyObj);
                            String propertyName = property.attributeValue("name");
                            String value = property.attributeValue("value");
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String getBean(String beanName){
        return "xxxxx";
    }

    public static void main(String[] args) {
        System.out.println(SpringUtil.getBean("aaa"));
    }
}
