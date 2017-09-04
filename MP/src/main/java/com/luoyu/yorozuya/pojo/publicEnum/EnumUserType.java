package com.luoyu.yorozuya.pojo.publicEnum;

/**
 * Created by 落羽 on 2017/8/31.
 * 用户类型
 */
public enum EnumUserType {
    DEFAULT("DEFAULT");
    private final String userType;
    private EnumUserType(String userType) {
        this.userType = userType;
    }
}
