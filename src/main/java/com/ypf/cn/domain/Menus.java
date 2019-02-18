package com.ypf.cn.domain;

import java.util.List;

public class Menus {
    private Integer id;

    private String text;

    private String icon;

    private String status;

    private String description;

    List<Childmenus> childmenus;
    
    

	public List<Childmenus> getChildmenus() {
		return childmenus;
	}

	public void setChildmenus(List<Childmenus> childmenus) {
		this.childmenus = childmenus;
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text == null ? null : text.trim();
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon == null ? null : icon.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }
}