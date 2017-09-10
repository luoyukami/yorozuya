package com.luoyu.yorozuya.service;

import com.luoyu.yorozuya.entity.ArticleInfo;
import com.luoyu.yorozuya.entity.User;
import com.luoyu.yorozuya.pojo.Article;
import com.luoyu.yorozuya.pojo.Result;
import com.luoyu.yorozuya.pojo.vo.ArticleListVO;
import com.luoyu.yorozuya.pojo.vo.ArticleVO;
import com.luoyu.yorozuya.repository.ArticleRepository;
import com.luoyu.yorozuya.utils.FileUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * 文章相关业务类
 *
 * @author ganxiang20970
 *         2017-08-27 21:06
 */
@Component
public class ArticleService {

    Logger logger = LoggerFactory.getLogger(ArticleService.class);

    @Value("${file.path}")
    private String FILE_PATH;

    @Value("${file.type}")
    private String FILE_TYPE;

    @Autowired
    private ArticleRepository articleRepository;

    /**
     * 保存文章数据
     * @param article 文章数据
     * @param user 用户信息
     * @return 操作结果
     */
    public Result saveArticle(Article article, User user) {
        Result result = new Result();
        //获取UUID文件名
        String fileName = FileUtil.getUUID() + FILE_TYPE;
        //上传文件
        Result uploadResult = FileUtil.uploadFile(article.getContent().getBytes(), FILE_PATH, fileName);
        //如果文件上传失败则返回
        if (!uploadResult.getSuccess()) {
            result.setSuccess(false);
            result.setInfo(uploadResult.getInfo());
            return result;
        }
        try {
            //文件上传 - 数据入库
            ArticleInfo articleInfo = new ArticleInfo();
            articleInfo.setAuthorId(user.getId());
            articleInfo.setArticleName(article.getTitle());
            articleInfo.setLocation(FILE_PATH + "/" + fileName);
            articleInfo.setStatus("1");//初次提交，待审核
            articleRepository.save(articleInfo);
        } catch (Exception e) {
            result.setSuccess(false);
            result.setInfo("插入文件数据失败！");
        }
        return result;
    }

    /**
     * 搜索文章
     * @param params 筛选参数
     * @return articleListVO
     */
    public ArticleListVO searchArticles(Map<String, Object> params) {
        ArticleListVO articleListVO = new ArticleListVO();
        articleListVO.setItems(articleRepository.findAll());
        return articleListVO;
    }

    /**
     * 根据文章编号获取文章内容
     * @param Id
     * @return
     */
    public ArticleVO getArticleById(Long Id) {
        ArticleVO articleVO = new ArticleVO();

        ArticleInfo articleInfo = articleRepository.findOne(Id);//获取文章信息
        Result result = FileUtil.getFileContentByReader(articleInfo.getLocation());//获取文章内容
        if (result.getSuccess()) {
            articleVO.setContent((String) result.getData());
        }

        articleVO.setItem(articleInfo);

        return articleVO;
    }

}
