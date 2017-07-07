package tech.washmore.demo.springboot.mongodb.repository;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created by Washmore on 2017/7/8.
 */
@Document(collection = "article")
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Data
public class MongdbArticle {
    @Id
    private String id;
    private String title;
    private String content;
}
