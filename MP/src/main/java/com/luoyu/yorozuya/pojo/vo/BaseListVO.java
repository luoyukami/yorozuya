package com.luoyu.yorozuya.pojo.vo;

import java.util.List;

/**
 * 基础列表VO
 *
 * @author ganxiang20970
 *         2017-09-04 21:40
 */
public class BaseListVO<T> {

    private List<T> items;//返回前台的list数据
    private Integer currentPage = 0;//当前页数
    private Integer pageSize = 20;//每页数据数量
    private Integer totalPage;//总的页数

    public List<T> getItems() {
        return items;
    }

    public void setItems(List<T> items) {
        this.items = items;
    }

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(Integer totalPage) {
        this.totalPage = totalPage;
    }

}
