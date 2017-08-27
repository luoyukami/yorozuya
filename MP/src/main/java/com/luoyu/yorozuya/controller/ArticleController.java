package com.luoyu.yorozuya.controller;

import com.luoyu.yorozuya.entity.User;
import com.luoyu.yorozuya.pojo.Article;
import com.luoyu.yorozuya.pojo.Result;
import com.luoyu.yorozuya.pojo.vo.ArticleListVO;
import com.luoyu.yorozuya.pojo.vo.ArticleVO;

import java.util.Map;

/**
 * @author ganxiang20970
 *         2017-08-27 20:55
 */
public interface ArticleController {

    /**
     * 保存文章
     * @param article 文章相关数据
     * @param user 发起请求的用户
     * @return 保存结果
     */
    Result saveArticle(Article article, User user);

    /**
     * 修改文章
     * @param article 文章相关数据
     * @param user 发起请求的用户
     * @return 修改结果
     */
    Result updateArtcile(Article article, User user);

    /**
     * 搜索文章
     * @param params 搜索条件
     * @return 文章列表VO
     */
    ArticleListVO searchArticle(Map<String, Object> params);

    /**
     * 获取文章内容等数据 - by id文章编号
     * @param id 文章编号
     * @return 文章VO
     */
    ArticleVO getArticle(Integer id);
}
