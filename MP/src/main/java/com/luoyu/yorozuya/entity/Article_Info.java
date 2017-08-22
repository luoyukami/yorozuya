package com.luoyu.yorozuya.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.sql.Timestamp;

/**
 * Created by 落羽 on 2017/8/22.
 * 文章表，存放关于文章的基本信息
 */
@Entity
public class Article_Info {
    @Id
    @GeneratedValue
    private int id;
    @Column(name = "articleName", columnDefinition = "varchar(64)")
    private String articleName;
    @Column(name = "authorld", columnDefinition = "varchar(32)")
    private String authorld;
    @Column(name = "creatTime")
    private Timestamp creatTime;
    @Column(name = "modifyTime")
    private Timestamp modifyTime;
    @Column(name = "location", columnDefinition = "varchar(256)")
    private String location;
    @Column(name = "status", columnDefinition = "char(2)")
    private String status;
    @Column(name = "pageView", columnDefinition = "bigInt")
    private Long pageView;
    @Column(name = "classCode", columnDefinition = "char(4)")
    private String classCode;
    @Column(name = "upvote", columnDefinition = "bigInt")
    private Long upvote;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getArticleName() {
        return articleName;
    }

    public void setArticleName(String articleName) {
        this.articleName = articleName;
    }

    public String getAuthorld() {
        return authorld;
    }

    public void setAuthorld(String authorld) {
        this.authorld = authorld;
    }

    public Timestamp getCreatTime() {
        return creatTime;
    }

    public void setCreatTime(Timestamp creatTime) {
        this.creatTime = creatTime;
    }

    public Timestamp getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Timestamp modifyTime) {
        this.modifyTime = modifyTime;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Long getPageView() {
        return pageView;
    }

    public void setPageView(Long pageView) {
        this.pageView = pageView;
    }

    public String getClassCode() {
        return classCode;
    }

    public void setClassCode(String classCode) {
        this.classCode = classCode;
    }

    public Long getUpvote() {
        return upvote;
    }

    public void setUpvote(Long upvote) {
        this.upvote = upvote;
    }
}
