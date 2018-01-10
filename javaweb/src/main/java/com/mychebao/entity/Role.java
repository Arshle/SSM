/*
 * Copyright (C), 2014-2017, 江苏乐博国际投资发展有限公司
 * FileName: Role.java
 * Author:   zhangdanji
 * Date:     2017年09月23日
 * Description:   
 */
package com.mychebao.entity;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * @author zhangdanji
 */
@Component("role")
public class Role implements Serializable {

    private static final long serialVersionUID = -7394255215440996367L;

    private int id;

    private String roleName;

    private String note;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
