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
public class ArticleInfo extends BaseEntity{

    private String articleName;
    private Long authorId;
    private String location;
    private String status;
    private Long pageView;
    private String classCode;
    private Long upVote;

    @Column(name = "articleName", columnDefinition = "varchar(64)")
    public String getArticleName() {
        return articleName;
    }

    @Column(name = "authorId", columnDefinition = "bigInt")
    public Long getAuthorId() {
        return authorId;
    }

    @Column(name = "location", columnDefinition = "varchar(256)")
    public String getLocation() {
        return location;
    }

    @Column(name = "status", columnDefinition = "char(2)")
    public String getStatus() {
        return status;
    }

    @Column(name = "pageView", columnDefinition = "bigInt")
    public Long getPageView() {
        return pageView;
    }

    @Column(name = "classCode", columnDefinition = "char(4)")
    public String getClassCode() {
        return classCode;
    }

    @Column(name = "upVote", columnDefinition = "bigInt")
    public Long getUpVote() {
        return upVote;
    }

    public void setArticleName(String articleName) {
        this.articleName = articleName;
    }

    public void setAuthorId(Long authorld) {
        this.authorId = authorld;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setPageView(Long pageView) {
        this.pageView = pageView;
    }

    public void setClassCode(String classCode) {
        this.classCode = classCode;
    }

    public void setUpVote(Long upVote) {
        this.upVote = upVote;
    }
}
