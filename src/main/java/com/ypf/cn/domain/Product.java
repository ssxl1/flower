package com.ypf.cn.domain;

import java.math.BigDecimal;
import java.util.Date;

public class Product {
    private Integer id;

    private Integer cid;

    private String name;

    private String subtitle;

    private BigDecimal originalprice;

    private BigDecimal nowprice;

    private Integer stock;

    private Integer imgid;

    private Date createdate;

    private Integer commentcount;

    private Integer salecount;

    private Date deleteat;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle == null ? null : subtitle.trim();
    }

    public BigDecimal getOriginalprice() {
        return originalprice;
    }

    public void setOriginalprice(BigDecimal originalprice) {
        this.originalprice = originalprice;
    }

    public BigDecimal getNowprice() {
        return nowprice;
    }

    public void setNowprice(BigDecimal nowprice) {
        this.nowprice = nowprice;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public Integer getImgid() {
        return imgid;
    }

    public void setImgid(Integer imgid) {
        this.imgid = imgid;
    }

    public Date getCreatedate() {
        return createdate;
    }

    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }

    public Integer getCommentcount() {
        return commentcount;
    }

    public void setCommentcount(Integer commentcount) {
        this.commentcount = commentcount;
    }

    public Integer getSalecount() {
        return salecount;
    }

    public void setSalecount(Integer salecount) {
        this.salecount = salecount;
    }

    public Date getDeleteat() {
        return deleteat;
    }

    public void setDeleteat(Date deleteat) {
        this.deleteat = deleteat;
    }
}