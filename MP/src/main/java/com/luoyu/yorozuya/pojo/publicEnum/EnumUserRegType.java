package com.luoyu.yorozuya.pojo.publicEnum;

/**
 * Created by 落羽 on 2017/9/1.
 * 用户注册方式
 */
public enum EnumUserRegType {
    PHONE("PHONE"),// 手机号
    EMAIL("EMALI"),// 邮箱
    QQ("QQ"),// QQ号
    WECHAT("WECHAT"),// 微信
    ACCOUNT("ACCOUNT");// 账户

    private final String userRegType;

    private EnumUserRegType(String userRegType) {
        this.userRegType = userRegType;
    }
}
