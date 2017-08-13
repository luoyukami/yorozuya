package com.luoyu.yorozuya.dto;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * 基础分页查询类（返回对象中包含List数据）
 *
 * @author ganxiang20970
 *         2017-08-13 21:01
 */
public class BasePageQuery extends BaseResponse {

    Logger log = LoggerFactory.getLogger(this.getClass());

    private final int DEFAULT_PAGE_SIZE = 10;

    private Integer pageSize;       //分页大小
    private Integer pageNumber;    //当前页数

    public Integer getPageNumber() {
        if(null == this.pageNumber) {
            log.info("---------查询时未指定当前页数---------");
            return 1;//当前页数未指定时，默认为首页
        }
        return pageNumber;
    }

    public void setPageNumber(Integer pageNumber) {
        this.pageNumber = pageNumber;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

}
