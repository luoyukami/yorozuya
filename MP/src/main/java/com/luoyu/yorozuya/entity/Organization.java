package com.luoyu.yorozuya.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;

/**
 * Created by 落羽 on 2017/8/31.
 * 系统结构
 */
@Entity
@Table(name = "sys_org")
@SQLDelete(sql = "UPDATE sys_org SET is_delete = 0 where id=?")
@Where(clause = "is_delete = 1")
public class Organization extends BaseEntity {
    @ManyToOne
    @JoinColumn(name = "parent_id", columnDefinition = "varchar(255)")
    @JsonIgnore
    private Organization parent; // 父级结构
    @Column(name = "parent_ids", columnDefinition = "varchar(255)")
    private String parentIds; // 父级编号树
    @Column(name = "org_name", columnDefinition = "char(20)")
    private String name; // 结构名称，例如(游戏区)
    @Column(name = "org_code", columnDefinition = "char(30)")
    private String code; // 结构编码(不一定要有)
    @Column(name = "is_delete", columnDefinition = "bit(1) default 1")
    private boolean isDelete; // 是否弃用z


    public Organization getParent() {
        return parent;
    }

    public String getParentIds() {
        return parentIds;
    }

    public String getName() {
        return name;
    }

    public String getCode() {
        return code;
    }


    public void setParent(Organization parent) {
        this.parent = parent;
    }

    public boolean isDelete() {
        return isDelete;
    }

    public void setDelete(boolean delete) {
        isDelete = delete;
    }

    public void setParentIds(String parentIds) {
        this.parentIds = parentIds;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setIsDelete(boolean isDelete) {
        this.isDelete = isDelete;
    }
}
