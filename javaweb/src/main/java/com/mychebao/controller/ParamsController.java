/*
 * Copyright (C), 2014-2017, 江苏乐博国际投资发展有限公司
 * FileName: ParamsController.java
 * Author:   zhangdanji
 * Date:     2017年09月29日
 * Description:   
 */
package com.mychebao.controller;

import com.mychebao.entity.Role;
import com.mychebao.service.RoleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author zhangdanji
 */
@Controller("paramsController")
@RequestMapping("/params")
public class ParamsController {

    private Logger logger = LoggerFactory.getLogger(ParamsController.class);

    @Resource
    private RoleService roleService;

    @RequestMapping("/toAddRole")
    public String toAddRole(){
        return "/jsp/addrole.jsp";
    }

    @RequestMapping("/addrole")
    public String addRole(HttpServletRequest request){
        String roleName = request.getParameter("roleName");
        String note = request.getParameter("note");
        Role role = new Role();
        role.setRoleName(roleName);
        role.setNote(note);
        if(roleService.insertRole(role) > 0){
            logger.info("新增成功:" + role.getId());
            return "/page/success.html";
        }else{
            return "/page/error.html";
        }
    }

    @RequestMapping("/findRoleInfo")
    @ResponseBody
    public Map<String,Object> findRoleInfo(RedirectAttributes redirectAttributes, HttpServletRequest request){
        String data = request.getParameter("roleData");
        try {
            InetAddress ia = InetAddress.getLocalHost();
            logger.info(ia.getHostAddress() + "IP");
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        logger.info("ajax :" + data);
        Map<String, Object> result = new HashMap<>();
        result.put("result", "success");
        logger.info("---findRoleInfo deal success---");
        redirectAttributes.addFlashAttribute("result","success");
        logger.info("---return result---");
        return result;
    }

    @RequestMapping("/index")
    @ResponseBody
    public Map<String,Object> index(HttpServletRequest request){
        logger.info("indexData:" + request.getParameter("roleData"));
        throw new RuntimeException("can't do this!!");
    }
}
