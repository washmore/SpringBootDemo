package tech.washmore.demo.springboot.blog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import tech.washmore.demo.springboot.blog.model.Article;
import tech.washmore.demo.springboot.blog.service.ArticleService;

import java.util.List;


/**
 * Created by Washmore on 2017/7/7.
 */
@Controller
public class ArticleController {
    @Autowired
    private ArticleService articleService;

    @RequestMapping("/topArticle")
    public ModelAndView articleTop5(ModelAndView mav) {
        mav.addObject("topAriticles", articleService.findTopArticles(5));
        mav.setViewName("article");
        return mav;
    }
}
