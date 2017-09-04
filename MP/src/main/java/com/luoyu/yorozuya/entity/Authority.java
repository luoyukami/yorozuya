package com.luoyu.yorozuya.entity;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by 落羽 on 2017/8/31.
 * 权限分类
 */
@Entity
@Table(name = "sys_auth")
@SQLDelete(sql = "Update sys_auth SET is_delete = 0 where id=?")
@Where(clause = "is_delete = 1")
public class Authority extends BaseEntity {
    private String code; //权限代码（英文名称 例如 AUTH_ALL）
    private String name; //中文名称
    private boolean isDelete; //是否弃用

    @Column(name = "code", columnDefinition = "char(30)")
    public String getCode() {
        return code;
    }
    @Column(name = "name", columnDefinition = "char(20)")
    public String getName() {
        return name;
    }
    @Column(name = "is_delete", columnDefinition = "bit(1) default 1")
    public boolean getIsDelete() {
        return isDelete;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setIsDelete(boolean isDelete) {
        this.isDelete = isDelete;
    }
}
