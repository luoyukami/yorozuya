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
public class Article_Location_His {
    @Id
    @GeneratedValue
    private int id;
    @Column(name = "articleId")
    private int articleId;
    @Column(name = "oldLocation", columnDefinition = "varchar(256)")
    private String oldLocation;
    @Column(name = "newLocation", columnDefinition = "varchar(256)")
    private String newLocation;
    @Column(name = "changeCount", columnDefinition = "smallint")
    private int changeCount;
    @Column(name = "modifyTime")
    private Timestamp modifyTime;
    @Column(name = "operatorId", columnDefinition = "varchar(32)")
    private String operatorId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getArticleId() {
        return articleId;
    }

    public void setArticleId(int articleId) {
        this.articleId = articleId;
    }

    public String getOldLocation() {
        return oldLocation;
    }

    public void setOldLocation(String oldLocation) {
        this.oldLocation = oldLocation;
    }

    public String getNewLocation() {
        return newLocation;
    }

    public void setNewLocation(String newLocation) {
        this.newLocation = newLocation;
    }

    public int getChangeCount() {
        return changeCount;
    }

    public void setChangeCount(int changeCount) {
        this.changeCount = changeCount;
    }

    public Timestamp getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Timestamp modifyTime) {
        this.modifyTime = modifyTime;
    }

    public String getOperatorId() {
        return operatorId;
    }

    public void setOperatorId(String operatorId) {
        this.operatorId = operatorId;
    }
}
