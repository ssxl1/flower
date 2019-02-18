package com.ypf.cn.domain;

public class Resume {
    private Integer id;

    private Integer ryear;

    private String rdescirption;

    private String rexperience;

    private String remail;

    private String rtel;

    private Integer rage;

    private String rname;

    private Integer pid;

    private String videopath;

    private String raddress;

    private String pname;

    private String rstatus;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRyear() {
        return ryear;
    }

    public void setRyear(Integer ryear) {
        this.ryear = ryear;
    }

    public String getRdescirption() {
        return rdescirption;
    }

    public void setRdescirption(String rdescirption) {
        this.rdescirption = rdescirption == null ? null : rdescirption.trim();
    }

    public String getRexperience() {
        return rexperience;
    }

    public void setRexperience(String rexperience) {
        this.rexperience = rexperience == null ? null : rexperience.trim();
    }

    public String getRemail() {
        return remail;
    }

    public void setRemail(String remail) {
        this.remail = remail == null ? null : remail.trim();
    }

    public String getRtel() {
        return rtel;
    }

    public void setRtel(String rtel) {
        this.rtel = rtel == null ? null : rtel.trim();
    }

    public Integer getRage() {
        return rage;
    }

    public void setRage(Integer rage) {
        this.rage = rage;
    }

    public String getRname() {
        return rname;
    }

    public void setRname(String rname) {
        this.rname = rname == null ? null : rname.trim();
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getVideopath() {
        return videopath;
    }

    public void setVideopath(String videopath) {
        this.videopath = videopath == null ? null : videopath.trim();
    }

    public String getRaddress() {
        return raddress;
    }

    public void setRaddress(String raddress) {
        this.raddress = raddress == null ? null : raddress.trim();
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname == null ? null : pname.trim();
    }

    public String getRstatus() {
        return rstatus;
    }

    public void setRstatus(String rstatus) {
        this.rstatus = rstatus == null ? null : rstatus.trim();
    }
}