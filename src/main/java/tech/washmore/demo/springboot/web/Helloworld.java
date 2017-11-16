package tech.washmore.demo.springboot.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Washmore
 * @version V1.0
 * @summary HelloWorld
 * @Copyright (c) 2017, www.washmore.tech
 * @since 2017/6/13
 */
@RestController
public class Helloworld {
    private static final Logger LOGGER = LoggerFactory.getLogger(Helloworld.class);

    @RequestMapping("/hello")
    public String helloWorld() {
        LOGGER.info("hello world!");
        return "helloworld!";
    }
}
