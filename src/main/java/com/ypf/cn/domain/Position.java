package com.ypf.cn.domain;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Position {
    private Integer id;
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd")
    private Date ceatedate;

    private String place;

    private Integer year;

    private String dept;

    private String education;

    private Integer num;

    private String descirption;

    private String ask;

    private String type;

    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getCeatedate() {
        return ceatedate;
    }

    public void setCeatedate(Date ceatedate) {
        this.ceatedate = ceatedate;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place == null ? null : place.trim();
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept == null ? null : dept.trim();
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education == null ? null : education.trim();
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public String getDescirption() {
        return descirption;
    }

    public void setDescirption(String descirption) {
        this.descirption = descirption == null ? null : descirption.trim();
    }

    public String getAsk() {
        return ask;
    }

    public void setAsk(String ask) {
        this.ask = ask == null ? null : ask.trim();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }
}