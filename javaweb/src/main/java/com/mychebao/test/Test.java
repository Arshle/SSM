/*
 * Copyright (C), 2014-2017, 江苏乐博国际投资发展有限公司
 * FileName: Test.java
 * Author:   zhangdanji
 * Date:     2017年09月23日
 * Description:   
 */
package com.mychebao.test;

import com.mychebao.entity.Role;
import com.mychebao.service.RoleListService;
import junit.framework.TestCase;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.core.RedisOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.SessionCallback;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.Pipeline;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author zhangdanji
 */
public class Test extends TestCase {

    public void testJavaEE(){
        ApplicationContext ctx = new ClassPathXmlApplicationContext("/spring/*.xml");
        RedisTemplate redisTemplate = ctx.getBean(RedisTemplate.class);
        String retVal = (String) redisTemplate.execute(new SessionCallback() {

            @Override
            public Object execute(RedisOperations redisOperations) throws DataAccessException {
                redisOperations.boundValueOps("mykey").set("myvalue");
                String value = (String) redisOperations.boundValueOps("mykey").get();
                return value;
            }
        });
        System.out.println(retVal);
    }
}
