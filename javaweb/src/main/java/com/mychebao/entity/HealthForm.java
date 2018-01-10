/*
 * Copyright (C), 2014-2017, 江苏乐博国际投资发展有限公司
 * FileName: HealthForm.java
 * Author:   zhangdanji
 * Date:     2017年09月26日
 * Description:   
 */
package com.mychebao.entity;

/**
 * @author zhangdanji
 */
public abstract class HealthForm {

    private int id;
    private int empId;
    private String heart;
    private String liver;
    private String spleen;
    private String lung;
    private String kidney;
    private String note;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    public String getHeart() {
        return heart;
    }

    public void setHeart(String heart) {
        this.heart = heart;
    }

    public String getLiver() {
        return liver;
    }

    public void setLiver(String liver) {
        this.liver = liver;
    }

    public String getSpleen() {
        return spleen;
    }

    public void setSpleen(String spleen) {
        this.spleen = spleen;
    }

    public String getLung() {
        return lung;
    }

    public void setLung(String lung) {
        this.lung = lung;
    }

    public String getKidney() {
        return kidney;
    }

    public void setKidney(String kidney) {
        this.kidney = kidney;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}