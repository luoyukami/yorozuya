package com.luoyu.yorozuya.controller.impl;

import com.luoyu.yorozuya.controller.ArticleController;
import com.luoyu.yorozuya.entity.User;
import com.luoyu.yorozuya.pojo.Article;
import com.luoyu.yorozuya.pojo.Result;
import com.luoyu.yorozuya.pojo.vo.ArticleListVO;
import com.luoyu.yorozuya.pojo.vo.ArticleVO;
import com.luoyu.yorozuya.service.ArticleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * 文章Controller实现类
 *
 * @author ganxiang20970
 *         2017-08-27 21:04
 */
@RequestMapping("/articles")
@Controller
public class ArticleControllerImpl implements ArticleController{

    @Autowired
    private ArticleService articleService;

    Logger logger = LoggerFactory.getLogger(ArticleController.class);


    @Override
    @PostMapping("/")
    public @ResponseBody Result saveArticle(Article article, User user) {
        Result result = null;
        /*表单必填数据校验*/
        if (article.isEmpty()) {
            result = new Result();
            result.setInfo("文章数据异常！");
            result.setSuccess(false);
            logger.error("文章数据异常："+ article.toString());
            return result;
        }
        return articleService.saveArticle(article, user);
    }

    @Override
    @PutMapping("/{id}")
    public @ResponseBody Result updateArtcile(@PathVariable Long id,Article article, User user) {
        return null;
    }

    @Override
    @GetMapping("/")
    public @ResponseBody ArticleListVO searchArticles(Map<String, Object> params) {
        return articleService.searchArticles(params);
    }

    @Override
    @GetMapping("/{id}")
    public @ResponseBody ArticleVO getArticle(@PathVariable Long id) {
        return articleService.getArticleById(id);
    }
}
