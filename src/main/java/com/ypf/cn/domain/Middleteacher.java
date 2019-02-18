package com.ypf.cn.domain;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Middleteacher {
    private Integer tid;

    private Integer cid;

    private Integer tuid;

    private String tname;

    private String ttel;

    private String tstatus;
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd")
    private Date tcreatedate;

    private String temail;

    private String tdescription;

    public Integer getTid() {
        return tid;
    }

    public void setTid(Integer tid) {
        this.tid = tid;
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public Integer getTuid() {
        return tuid;
    }

    public void setTuid(Integer tuid) {
        this.tuid = tuid;
    }

    public String getTname() {
        return tname;
    }

    public void setTname(String tname) {
        this.tname = tname == null ? null : tname.trim();
    }

    public String getTtel() {
        return ttel;
    }

    public void setTtel(String ttel) {
        this.ttel = ttel == null ? null : ttel.trim();
    }

    public String getTstatus() {
        return tstatus;
    }

    public void setTstatus(String tstatus) {
        this.tstatus = tstatus == null ? null : tstatus.trim();
    }

    public Date getTcreatedate() {
        return tcreatedate;
    }

    public void setTcreatedate(Date tcreatedate) {
        this.tcreatedate = tcreatedate;
    }

    public String getTemail() {
        return temail;
    }

    public void setTemail(String temail) {
        this.temail = temail == null ? null : temail.trim();
    }

    public String getTdescription() {
        return tdescription;
    }

    public void setTdescription(String tdescription) {
        this.tdescription = tdescription == null ? null : tdescription.trim();
    }
}