/*
 * Copyright (C), 2014-2017, 江苏乐博国际投资发展有限公司
 * FileName: RoleServiceImpl.java
 * Author:   zhangdanji
 * Date:     2017年09月27日
 * Description:   
 */
package com.mychebao.service.impl;

import com.mychebao.entity.Role;
import com.mychebao.mappers.RoleMapper;
import com.mychebao.service.RoleService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @author zhangdanji
 */
@Service("roleService")
public class RoleServiceImpl implements RoleService {

    @Resource
    private RoleMapper roleMapper;

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW,isolation = Isolation.READ_COMMITTED)
    public int insertRole(Role role) {
        return roleMapper.insertRole(role);
    }
}
