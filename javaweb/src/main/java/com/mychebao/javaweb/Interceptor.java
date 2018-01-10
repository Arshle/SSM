/*
 * Copyright (C), 2014-2017, 江苏乐博国际投资发展有限公司
 * FileName: Interceptor.java
 * Author:   zhangdanji
 * Date:     2017年09月22日
 * Description:   
 */
package com.mychebao.javaweb;

import java.lang.reflect.Method;

/**
 * @author zhangdanji
 */
public interface Interceptor {

    public boolean before(Object proxy, Object target, Method method,Object[] args);

    public void around(Object proxy,Object target,Method method,Object[] args);

    public void after(Object proxy,Object target,Method method,Object[] args);
}
