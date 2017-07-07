package tech.washmore.demo.springboot.mongodb.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Washmore on 2017/7/8.
 */
@Repository
public interface ArticleRepository extends MongoRepository<MongdbArticle, String> {
}
