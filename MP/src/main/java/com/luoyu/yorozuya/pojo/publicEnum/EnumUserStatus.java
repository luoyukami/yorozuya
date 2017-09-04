package com.luoyu.yorozuya.pojo.publicEnum;

/**
 * Created by 落羽 on 2017/8/31.
 * 用户状态(暂时只做存储用户是否被冻结、禁言等账户性质状态)
 */
public enum EnumUserStatus {
    NORMAL("NORMAL"),// 普通状态
    FREEZING("FREEZING"),// 冻结状态
    SILENCE("SILENCE"),// 禁言状态
    DELETE("DELETE"),// 删除状态
    ;
    private  final String status;
    private EnumUserStatus(String status) {
        this.status = status;
    }
}
