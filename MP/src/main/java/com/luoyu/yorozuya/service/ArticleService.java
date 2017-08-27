package com.luoyu.yorozuya.service;

import com.luoyu.yorozuya.entity.User;
import com.luoyu.yorozuya.pojo.Article;
import com.luoyu.yorozuya.pojo.Result;
import org.springframework.stereotype.Component;

/**
 * 文章相关业务类
 *
 * @author ganxiang20970
 *         2017-08-27 21:06
 */
@Component
public class ArticleService {

    /**
     * 保存文章数据
     * @param article 文章数据
     * @param user 用户信息
     * @return 操作结果
     */
    public Result saveArticle(Article article, User user) {
        return null;
    }
}
