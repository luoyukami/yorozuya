package com.luoyu.yorozuya.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.sql.Timestamp;

/**
 * Created by 落羽 on 2017/8/22.
 * 文章分区表
 */
@Entity
public class Article_Class {
    @Id
    @GeneratedValue
    private int id;
    @Column(name = "classCode", columnDefinition = "char(4)")
    private String classCode;
    @Column(name = "classNameCN", columnDefinition = "varchar(32)")
    private String classNameCN;
    @Column(name = "classNameEN", columnDefinition = "varchar(32)")
    private String classNameEN;
    @Column(name = "status")
    private String status;
    @Column(name = "classContent", columnDefinition = "varchar(255)")
    private String classContent;
    @Column(name = "operatorId")
    private int operatorId;
    @Column(name = "createTime")
    private Timestamp createTime;
    @Column(name = "modifyTime")
    private Timestamp modifyTime;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getClassCode() {
        return classCode;
    }

    public void setClassCode(String classCode) {
        this.classCode = classCode;
    }

    public String getClassNameCN() {
        return classNameCN;
    }

    public void setClassNameCN(String classNameCN) {
        this.classNameCN = classNameCN;
    }

    public String getClassNameEN() {
        return classNameEN;
    }

    public void setClassNameEN(String classNameEN) {
        this.classNameEN = classNameEN;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getClassContent() {
        return classContent;
    }

    public void setClassContent(String classContent) {
        this.classContent = classContent;
    }

    public int getOperatorId() {
        return operatorId;
    }

    public void setOperatorId(int operatorId) {
        this.operatorId = operatorId;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    public Timestamp getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Timestamp modifyTime) {
        this.modifyTime = modifyTime;
    }
}
