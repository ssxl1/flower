package com.ypf.cn.domain;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class News {
    private Integer id;

    private String title;

    private String authors;

    private String descirption;
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd")
    private Date createdate;

    private Integer num;

    private String content;
    
    public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getAuthors() {
        return authors;
    }

    public void setAuthors(String authors) {
        this.authors = authors == null ? null : authors.trim();
    }

    public String getDescirption() {
        return descirption;
    }

    public void setDescirption(String descirption) {
        this.descirption = descirption == null ? null : descirption.trim();
    }

    public Date getCreatedate() {
        return createdate;
    }

    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }
}