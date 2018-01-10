/*
 * Copyright (C), 2014-2017, 江苏乐博国际投资发展有限公司
 * FileName: RoleListServiceImpl.java
 * Author:   zhangdanji
 * Date:     2017年09月28日
 * Description:   
 */
package com.mychebao.service.impl;

import com.mychebao.entity.Role;
import com.mychebao.service.RoleListService;
import com.mychebao.service.RoleService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author zhangdanji
 */
@Service("roleListService")
public class RoleListServiceImpl implements RoleListService {

    @Resource
    private RoleService roleService;

    @Override
    @Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.READ_COMMITTED)
    public int insertRoleList(List<Role> roleList) {
        int count = 0;
        for(Role role : roleList){
            try {
                count += roleService.insertRole(role);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return count;
    }
}
