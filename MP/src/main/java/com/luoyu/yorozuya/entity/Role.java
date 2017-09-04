package com.luoyu.yorozuya.entity;

import com.luoyu.yorozuya.pojo.publicEnum.EnumDataScope;
import com.luoyu.yorozuya.pojo.publicEnum.EnumRoleType;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by 落羽 on 2017/8/31.
 * 权限角色
 */
@Entity
@Table(name = "sys_role")
@SQLDelete(sql = "UPDATE sys_role SET is_delete = 0 where id=?")
@Where(clause = "is_delete = 1")
public class Role extends BaseEntity {
    @ManyToMany
    @JoinTable(name = "sys_role_org", joinColumns = @JoinColumn(name = "role_id"), inverseJoinColumns = @JoinColumn(name = "org_id"))
    private Set<Organization> organizations; // 角色和结构
    @ManyToMany
    @JoinTable(name = "sys_role_auth", joinColumns = @JoinColumn(name = "role_id"), inverseJoinColumns = @JoinColumn(name = "auth_id"))
    private Set<Authority> authorities; // 角色和权限
    @Column(name = "name", columnDefinition = "char(20)")
    private String name; // 角色名称
    @Column(name = "code", columnDefinition = "char(30)")
    private String code; // 角色代码
    @Column(name = "role_type", columnDefinition = "char(30)")
    @Enumerated(EnumType.STRING)
    private EnumRoleType roleType; // 权限角色类型
    @Column(name = "data_scope", columnDefinition = "char(30)")
    @Enumerated(EnumType.STRING)
    private EnumDataScope dataScope; // 访问数据范围
    @Column(name = "is_delete", columnDefinition = "bit(1) default 1")
    private boolean isDelete; // 是否删除 1代表否


    public Set<Organization> getOrganizations() {
        return organizations;
    }

    public Set<Authority> getAuthorities() {
        return authorities;
    }

    public String getName() {
        return name;
    }

    public String getCode() {
        return code;
    }

    public EnumRoleType getRoleType() {
        return roleType;
    }

    public EnumDataScope getDataScope() {
        return dataScope;
    }

    public boolean isDelete() {
        return isDelete;
    }

    public void setOrganizations(Set<Organization> organizations) {
        this.organizations = organizations;
    }

    public void setAuthorities(Set<Authority> authorities) {
        this.authorities = authorities;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setRoleType(EnumRoleType roleType) {
        this.roleType = roleType;
    }

    public void setDataScope(EnumDataScope dataScope) {
        this.dataScope = dataScope;
    }

    public void setDelete(boolean delete) {
        isDelete = delete;
    }
}
