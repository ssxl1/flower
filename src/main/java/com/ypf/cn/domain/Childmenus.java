package com.ypf.cn.domain;

public class Childmenus {
    private Integer id;

    private String ctext;

    private String cicon;

    private String href;

    private Integer menuid;

    private String cdescription;

    private String cstatus;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCtext() {
        return ctext;
    }

    public void setCtext(String ctext) {
        this.ctext = ctext == null ? null : ctext.trim();
    }

    public String getCicon() {
        return cicon;
    }

    public void setCicon(String cicon) {
        this.cicon = cicon == null ? null : cicon.trim();
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href == null ? null : href.trim();
    }

    public Integer getMenuid() {
        return menuid;
    }

    public void setMenuid(Integer menuid) {
        this.menuid = menuid;
    }

    public String getCdescription() {
        return cdescription;
    }

    public void setCdescription(String cdescription) {
        this.cdescription = cdescription == null ? null : cdescription.trim();
    }

    public String getCstatus() {
        return cstatus;
    }

    public void setCstatus(String cstatus) {
        this.cstatus = cstatus == null ? null : cstatus.trim();
    }
}