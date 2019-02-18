package com.ypf.cn.domain;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Classroom {
    private Integer id;

    private String name;

    private String descirption;
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd")
    private Date createdate;

    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd")
    private Date enddate;
    
    private String status;

    private String type;

    private Integer price;

    private Integer num;
    private	double	allmoney;
    
    
    List<Middlestudent> studentlist;
    
    List<Middleteacher> teacherlist;
    
    
    private String teacher;
    
    
    
    public double getAllmoney() {
		return allmoney;
	}

	public void setAllmoney(double allmoney) {
		this.allmoney = allmoney;
	}

	public Date getEnddate() {
		return enddate;
	}

	public void setEnddate(Date enddate) {
		this.enddate = enddate;
	}

	public String getTeacher() {
		return teacher;
	}

	public void setTeacher(String teacher) {
		this.teacher = teacher;
	}

	public List<Middlestudent> getStudentlist() {
		return studentlist;
	}

	public void setStudentlist(List<Middlestudent> studentlist) {
		this.studentlist = studentlist;
	}

	public List<Middleteacher> getTeacherlist() {
		return teacherlist;
	}

	public void setTeacherlist(List<Middleteacher> teacherlist) {
		this.teacherlist = teacherlist;
	}

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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }
}