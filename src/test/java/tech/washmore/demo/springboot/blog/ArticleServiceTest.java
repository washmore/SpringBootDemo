package tech.washmore.demo.springboot.blog;

import com.alibaba.fastjson.JSON;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import tech.washmore.demo.springboot.BaseTest;
import tech.washmore.demo.springboot.blog.dao.ArticleDao;
import tech.washmore.demo.springboot.blog.model.Article;
import tech.washmore.demo.springboot.blog.service.ArticleService;

import java.util.List;


/**
 * Created by Washmore on 2017/7/7.
 */
public class ArticleServiceTest extends BaseTest {
    @Autowired
    private ArticleService articleService;

    @Test
    public void testFindTopArticles() {
        List<Article> articles = articleService.findTopArticles(10);
        Assert.notNull(articles, "空对象");
        System.out.println(JSON.toJSONString(articles, true));
    }
}
