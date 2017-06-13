package tech.washmore.demo.springboot.web;

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
    @RequestMapping("/hello")
    public String helloWorld() {
        return "helloworld";
    }
}
