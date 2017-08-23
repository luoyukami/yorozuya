package com.luoyu.yorozuya.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.sql.Timestamp;

/**
 * Created by 落羽 on 2017/8/22.
 * 文章地址历史表，存放文章修改的历史信息
 */
@Entity
public class ArticleLocationHis {

    private int id;
    private int articleId;
    private String oldLocation;
    private String newLocation;
    private int changeCount;
    private Timestamp modifyTime;
    private String operatorId;

    @Id
    @GeneratedValue
    public int getId() {
        return id;
    }

    @Column(name = "articleId")
    public int getArticleId() {
        return articleId;
    }

    @Column(name = "oldLocation", columnDefinition = "varchar(256)")
    public String getOldLocation() {
        return oldLocation;
    }

    @Column(name = "newLocation", columnDefinition = "varchar(256)")
    public String getNewLocation() {
        return newLocation;
    }

    @Column(name = "changeCount", columnDefinition = "smallint")
    public int getChangeCount() {
        return changeCount;
    }

    @Column(name = "modifyTime")
    public Timestamp getModifyTime() {
        return modifyTime;
    }

    @Column(name = "operatorId", columnDefinition = "varchar(32)")
    public String getOperatorId() {
        return operatorId;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setArticleId(int articleId) {
        this.articleId = articleId;
    }

    public void setOldLocation(String oldLocation) {
        this.oldLocation = oldLocation;
    }

    public void setNewLocation(String newLocation) {
        this.newLocation = newLocation;
    }

    public void setChangeCount(int changeCount) {
        this.changeCount = changeCount;
    }

    public void setModifyTime(Timestamp modifyTime) {
        this.modifyTime = modifyTime;
    }

    public void setOperatorId(String operatorId) {
        this.operatorId = operatorId;
    }
}
