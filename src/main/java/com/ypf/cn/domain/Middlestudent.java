package com.ypf.cn.domain;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Middlestudent {
    private Integer sid;
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd")
    private Date screatedate;

    private Integer uid;

    private String sstatus;

    private String sdescription;

    private String sname;

    private String stel;

    private String semail;

    private Integer cid;

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public Date getScreatedate() {
        return screatedate;
    }

    public void setScreatedate(Date screatedate) {
        this.screatedate = screatedate;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getSstatus() {
        return sstatus;
    }

    public void setSstatus(String sstatus) {
        this.sstatus = sstatus == null ? null : sstatus.trim();
    }

    public String getSdescription() {
        return sdescription;
    }

    public void setSdescription(String sdescription) {
        this.sdescription = sdescription == null ? null : sdescription.trim();
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname == null ? null : sname.trim();
    }

    public String getStel() {
        return stel;
    }

    public void setStel(String stel) {
        this.stel = stel == null ? null : stel.trim();
    }

    public String getSemail() {
        return semail;
    }

    public void setSemail(String semail) {
        this.semail = semail == null ? null : semail.trim();
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }
}