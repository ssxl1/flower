package com.ypf.cn.domain;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Arts {
    private Integer id;

    private String title;

    private String name;

    private String address;
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd")
    private Date createdate;

    private String status;

    private String descirption;

    private Integer membernum;

    private String useful;

    private String content;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public Date getCreatedate() {
        return createdate;
    }

    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public String getDescirption() {
        return descirption;
    }

    public void setDescirption(String descirption) {
        this.descirption = descirption == null ? null : descirption.trim();
    }

    public Integer getMembernum() {
        return membernum;
    }

    public void setMembernum(Integer membernum) {
        this.membernum = membernum;
    }

    public String getUseful() {
        return useful;
    }

    public void setUseful(String useful) {
        this.useful = useful == null ? null : useful.trim();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }
}