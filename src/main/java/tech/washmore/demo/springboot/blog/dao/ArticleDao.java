package tech.washmore.demo.springboot.blog.dao;

import com.google.common.collect.Maps;
import org.springframework.stereotype.Repository;
import tech.washmore.demo.springboot.blog.model.Article;

import java.util.List;
import java.util.Map;

/**
 * Created by Washmore on 2017/7/7.
 */
@Repository
public class ArticleDao extends BaseDao {
    public List<Article> findTopArticles(int top) {
        Map<String, Object> params = Maps.newHashMap();
        params.put("top", top);
        return super.getSqlSession().selectList("selectTop", params);
    }
}
