/*
 * Copyright (C), 2014-2017, 江苏乐博国际投资发展有限公司
 * FileName: ProxyBeanFactory.java
 * Author:   zhangdanji
 * Date:     2017年09月27日
 * Description:   
 */
package com.mychebao.factory;

import com.mychebao.interceptor.Interceptor;
import com.mychebao.util.ProxyBeanUtil;

/**
 * @author zhangdanji
 */
public class ProxyBeanFactory {

    @SuppressWarnings("unchecked")
    public static <T> T getBean(T obj, Interceptor interceptor){
        return (T) ProxyBeanUtil.getBean(obj,interceptor);
    }
}
