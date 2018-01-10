/*
 * Copyright (C), 2014-2017, 江苏乐博国际投资发展有限公司
 * FileName: RoleInterceptor.java
 * Author:   zhangdanji
 * Date:     2017年09月27日
 * Description:   
 */
package com.mychebao.interceptor;

/**
 * @author zhangdanji
 */
public class RoleInterceptor implements Interceptor {
    @Override
    public void before(Object obj) {
        System.out.println("准备打印角色信息");
    }

    @Override
    public void after(Object obj) {
        System.out.println("已经完成角色信息打印处理");
    }

    @Override
    public void afterReturning(Object obj) {
        System.out.println("刚刚完成打印，一切正常");
    }

    @Override
    public void afterThrowing(Object obj) {
        System.out.println("打印异常");
    }
}
