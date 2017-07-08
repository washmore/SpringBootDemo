package tech.washmore.demo.springboot.mongodb;

import com.alibaba.fastjson.JSON;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import tech.washmore.demo.springboot.BaseTest;
import tech.washmore.demo.springboot.mongodb.repository.ArticleRepository;
import tech.washmore.demo.springboot.mongodb.repository.ArticleRepositoryImpl;
import tech.washmore.demo.springboot.mongodb.repository.MongdbArticle;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Washmore on 2017/7/8.
 */
public class TestMongDbCURD extends BaseTest {

    @Autowired
    private ArticleRepository articleRepository;
    @Autowired
    private ArticleRepositoryImpl articleRepositoryImpl;

    @Test
    public void addData() {
        for (int i = 275237; i < 10000000; i += 200000) {
            final int start = i;
            new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int s = start; s < start + 200000; s++) {
                        MongdbArticle mongdbArticle1 = new MongdbArticle(null, "文章标题1" + s, "我们都是中国人233333" + s);
                        MongdbArticle mongdbArticle2 = new MongdbArticle(null, "文章标题11" + s, "我们都是地球人233333" + s);
                        MongdbArticle mongdbArticle3 = new MongdbArticle(null, "文章标题111" + s, "我们都是亚洲人233333" + s);
                        MongdbArticle mongdbArticle4 = new MongdbArticle(null, "文章标题1111" + s, "我们不是日本人233333" + s);
                        MongdbArticle mongdbArticle5 = new MongdbArticle(null, "文章标题11111" + s, "不转不是中国人233333" + s);
                        MongdbArticle mongdbArticle6 = new MongdbArticle(null, "文章标题111111" + s, "都是些什么人233333" + s);
                        articleRepository.save(mongdbArticle1);
                        articleRepository.save(mongdbArticle2);
                        articleRepository.save(mongdbArticle3);
                        articleRepository.save(Arrays.asList(mongdbArticle4, mongdbArticle5, mongdbArticle6));
                        System.out.println(Thread.currentThread().getName() + ":" + s);
                    }
                }
            }).start();
        }

        new Scanner(System.in).next();
    }


    @Test
    public void testFindByTitle() {
        MongdbArticle article = articleRepositoryImpl.findByTitle("文章标题111111");
        Assert.notNull(article, "空对象");
        System.out.println(JSON.toJSONString(article, true));
    }

    @Test
    public void testFindByContent() {
        List<MongdbArticle> articles = articleRepositoryImpl.findByContent("我们都是");
        Assert.notNull(articles, "空对象");
        System.out.println(JSON.toJSONString(articles, true));
    }
}
