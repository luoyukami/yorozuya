package com.luoyu.yorozuya.dto;

/**
 * 基础响应类
 * 所有的响应类均需要继承此类
 * @author ganxiang20970
 *         2017-08-13 21:00
 */
public class BaseResponse {

    private boolean success;    //成功的标示
    private String msg;         //执行信息
    private Long operatorId;    //操作者编号

    public Long getOperatorId() {
        return operatorId;
    }

    public void setOperatorId(Long operatorId) {
        this.operatorId = operatorId;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }
}
