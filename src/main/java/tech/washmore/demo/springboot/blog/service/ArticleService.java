package tech.washmore.demo.springboot.blog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.washmore.demo.springboot.blog.dao.ArticleDao;
import tech.washmore.demo.springboot.blog.model.Article;

import java.util.List;


/**
 * Created by Washmore on 2017/7/7.
 */
@Service
public class ArticleService {
    @Autowired
    private ArticleDao articleDao;

    public List<Article> findTopArticles(int top) {
        return articleDao.findTopArticles(top);
    }
}
