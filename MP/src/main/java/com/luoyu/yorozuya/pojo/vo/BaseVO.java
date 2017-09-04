package com.luoyu.yorozuya.pojo.vo;

/**
 * 基础VO类
 *
 * @author ganxiang20970
 *         2017-09-04 21:41
 */
public class BaseVO<T> {

    private T item;//查询返回的单个对象

    public T getItem() {
        return item;
    }

    public void setItem(T item) {
        this.item = item;
    }
}
