package tech.washmore.demo.springboot.blog.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by Washmore on 2017/7/7.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Article {
    private String title;
    private String content;
}
