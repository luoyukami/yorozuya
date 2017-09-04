package com.luoyu.yorozuya.pojo.vo;

import com.luoyu.yorozuya.entity.ArticleInfo;

/**
 * 文章VO
 * 用于显示具体文章的详细信息
 * @author ganxiang20970
 *         2017-08-27 20:53
 */
public class ArticleVO extends BaseVO<ArticleInfo> {
    private String content;//文章内容

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
