package com.luoyu.yorozuya.pojo;

import java.util.List;

/**
 * 结果类 - 一般作为操作的结果返回
 *
 * @author ganxiang20970
 *         2017-08-27 19:05
 */
public class Result<T> {
    private Boolean success = true;//操作是否成功的标志
    private String info;//操作返回的信息（可能）
    private List<T> list;//操作返回的列表数据（可能）
    private Object data;//操作返回的单个数据（可能）

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }
}
