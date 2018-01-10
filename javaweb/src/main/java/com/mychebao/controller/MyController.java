/*
 * Copyright (C), 2014-2017, 江苏乐博国际投资发展有限公司
 * FileName: MyController.java
 * Author:   zhangdanji
 * Date:     2017年09月28日
 * Description:   
 */
package com.mychebao.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.net.MalformedURLException;

/**
 * @author zhangdanji
 */
@Controller("myController")
@RequestMapping("/my")
public class MyController {

    @RequestMapping("/index")
    public String index(HttpServletRequest request){
        try {
            System.out.println(request.getServletContext().getResource("/").getPath());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return "/page/index.html";
    }
}
