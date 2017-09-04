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

    private Organization parent; // 父级结构
    private String parentIds; // 父级编号树
    private String name; // 结构名称，例如(游戏区)
    private String code; // 结构编码(不一定要有)
    private boolean isDelete; // 是否弃用

    @ManyToOne
    @JoinColumn(name = "parent_id", columnDefinition = "varchar(255)")
    @JsonIgnore
    public Organization getParent() {
        return parent;
    }
    @Column(name = "parent_ids", columnDefinition = "varchar(255)")
    public String getParentIds() {
        return parentIds;
    }
    @Column(name = "org_name", columnDefinition = "char(20)")
    public String getName() {
        return name;
    }
    @Column(name = "org_code", columnDefinition = "char(30)")
    public String getCode() {
        return code;
    }
    @Column(name = "is_delete", columnDefinition = "bit(1) default 1")
    public boolean getIsDelete() {
        return isDelete;
    }

    public void setParent(Organization parent) {
        this.parent = parent;
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
