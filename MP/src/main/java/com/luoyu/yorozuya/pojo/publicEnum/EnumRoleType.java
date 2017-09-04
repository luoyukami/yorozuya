package com.luoyu.yorozuya.pojo.publicEnum;

/**
 * Created by 落羽 on 2017/8/31.
 * 角色类型
 */
public enum EnumRoleType {
    DEFAULT("DEFAULT");
    private final String roleType;
    private EnumRoleType(String roleType) {
        this.roleType = roleType;
    }
}
