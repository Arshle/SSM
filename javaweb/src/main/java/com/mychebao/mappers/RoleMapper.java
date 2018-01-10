/*
 * Copyright (C), 2014-2017, 江苏乐博国际投资发展有限公司
 * FileName: RoleMapper.java
 * Author:   zhangdanji
 * Date:     2017年09月23日
 * Description:   
 */
package com.mychebao.mappers;

import com.mychebao.entity.Role;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @author zhangdanji
 */
@Repository
public interface RoleMapper {

    public int insertRole(Role role);

    public Role getRole(@Param("id") int id);

    public int updateRole(Role role);

    public int deleteRole(@Param("id") int id);
}
