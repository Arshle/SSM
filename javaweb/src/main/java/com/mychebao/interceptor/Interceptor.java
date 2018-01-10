/*
 * Copyright (C), 2014-2017, 江苏乐博国际投资发展有限公司
 * FileName: Interceptor.java
 * Author:   zhangdanji
 * Date:     2017年09月27日
 * Description:   
 */
package com.mychebao.interceptor;

/**
 * @author zhangdanji
 */
public interface Interceptor {
    public void before(Object obj);

    public void after(Object obj);

    public void afterReturning(Object obj);

    public void afterThrowing(Object obj);
}
