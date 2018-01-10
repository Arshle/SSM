/*
 * Copyright (C), 2014-2017, 江苏乐博国际投资发展有限公司
 * FileName: MybatisUtil.java
 * Author:   zhangdanji
 * Date:     2017年09月23日
 * Description:   
 */
package com.mychebao.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author zhangdanji
 */
public class MybatisUtil {

    private final static Class<MybatisUtil> LOCK = MybatisUtil.class;

    private static SqlSessionFactory sqlSessionFactory;

    public static SqlSessionFactory getSqlSessionFactory() {

        synchronized (LOCK){
            if(sqlSessionFactory == null){
                String resource = "mybatis-config.xml";
                InputStream is = null;
                try {
                    is = Resources.getResourceAsStream(resource);
                    sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return sqlSessionFactory;
        }
    }
}
