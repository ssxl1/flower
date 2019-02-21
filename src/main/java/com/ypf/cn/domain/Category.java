package com.ypf.cn.domain;

import java.util.Date;

public class Category {
    private Integer id;

    private String name;

    private Integer recommend;

    private Date deleteat;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getRecommend() {
        return recommend;
    }

    public void setRecommend(Integer recommend) {
        this.recommend = recommend;
    }

    public Date getDeleteat() {
        return deleteat;
    }

    public void setDeleteat(Date deleteat) {
        this.deleteat = deleteat;
    }
}