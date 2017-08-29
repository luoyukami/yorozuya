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
public class ArticleLocationHis extends BaseEntity{

    private Long articleId;
    private String oldLocation;
    private String newLocation;
    private int changeCount;
    private Long operatorId;


    @Column(name = "articleId", columnDefinition = "bigInt")
    public Long getArticleId() {
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


    @Column(name = "operatorId", columnDefinition = "varchar(32)")
    public Long getOperatorId() {
        return operatorId;
    }

    public void setArticleId(Long articleId) {
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

    public void setOperatorId(Long operatorId) {
        this.operatorId = operatorId;
    }
}
