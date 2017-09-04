package test.com.luoyu.yorozuya.service; 

import com.luoyu.yorozuya.entity.User;
import com.luoyu.yorozuya.pojo.Article;
import com.luoyu.yorozuya.service.ArticleService;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After; 

/** 
* ArticleService Tester. 
* 
* @author <Authors name> 
* @since <pre>八月 28, 2017</pre> 
* @version 1.0 
*/ 
public class ArticleServiceTest { 

@Before
public void before() throws Exception { 
} 

@After
public void after() throws Exception { 
} 

/** 
* 
* Method: saveArticle(Article article, User user) 
* 
*/ 
@Test
public void testSaveArticle() throws Exception { 
//TODO: Test goes here...
    ArticleService articleService = new ArticleService();
    articleService.saveArticle(new Article(), new User());
} 


} 
