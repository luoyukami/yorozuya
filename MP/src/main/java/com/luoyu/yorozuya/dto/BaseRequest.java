package com.luoyu.yorozuya.dto;

/**
 * 基础请求类
 * 所有的请求均需要继承此类
 * @author ganxiang20970
 *         2017-08-13 20:59
 */
public class BaseRequest {

    private String operatorId;  //操作员编号

    public String getOperatorId() {
        return operatorId;
    }

    public void setOperatorId(String operatorId) {
        this.operatorId = operatorId;
    }
}
