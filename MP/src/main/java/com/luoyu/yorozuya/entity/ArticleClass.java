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
public class ArticleClass extends BaseEntity{

    private String classCode;//分类代码
    private String classNameCN;//分类中文名
    private String classNameEN;//分类英文名
    private String status;
    private String classContent;
    private Long operatorId;

    @Column(name = "classCode", columnDefinition = "char(4)")
    public String getClassCode() {
        return classCode;
    }

    @Column(name = "classNameCN", columnDefinition = "varchar(32)")
    public String getClassNameCN() {
        return classNameCN;
    }

    @Column(name = "classNameEN", columnDefinition = "varchar(32)")
    public String getClassNameEN() {
        return classNameEN;
    }

    @Column(name = "status")
    public String getStatus() {
        return status;
    }

    @Column(name = "classContent", columnDefinition = "varchar(255)")
    public String getClassContent() {
        return classContent;
    }
    @Column(name = "operatorId")
    public Long getOperatorId() {
        return operatorId;
    }

    public void setClassCode(String classCode) {
        this.classCode = classCode;
    }

    public void setClassNameCN(String classNameCN) {
        this.classNameCN = classNameCN;
    }

    public void setClassNameEN(String classNameEN) {
        this.classNameEN = classNameEN;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setClassContent(String classContent) {
        this.classContent = classContent;
    }

    public void setOperatorId(Long operatorId) {
        this.operatorId = operatorId;
    }
}
