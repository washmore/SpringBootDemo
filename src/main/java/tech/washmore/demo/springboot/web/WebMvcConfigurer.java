package tech.washmore.demo.springboot.web;

import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.CacheControl;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.concurrent.TimeUnit;

/**
 * @author zhaojian
 * @version v1
 * @since 2016-11-30
 */
@Configuration
@ConditionalOnWebApplication
public class WebMvcConfigurer extends WebMvcConfigurerAdapter {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        CacheControl cacheControl = CacheControl.maxAge(8, TimeUnit.HOURS);
        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/pages/").setCacheControl(cacheControl);
    }

}
