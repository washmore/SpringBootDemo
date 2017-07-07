package tech.washmore.demo.springboot.mongodb.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * Created by Washmore on 2017/7/8.
 */
@Repository
public class ArticleRepositoryImpl {

    @Autowired
    private MongoTemplate mongoTemplate;

    public MongdbArticle findByTitle(String title) {
        List<MongdbArticle> mongdbArticles = mongoTemplate.find(new Query().addCriteria(Criteria.where("title").regex(title)).limit(1), MongdbArticle.class);
        if (CollectionUtils.isEmpty(mongdbArticles)) {
            return null;
        }
        return mongdbArticles.get(0);
    }

    public List<MongdbArticle> findByContent(String content) {
        return mongoTemplate.find(new Query().addCriteria(Criteria.where("content").regex(content)), MongdbArticle.class);
    }
}
