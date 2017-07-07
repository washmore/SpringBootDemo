package tech.washmore.demo.springboot.themeleaf;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author Washmore
 * @version V1.0
 * @summary themeleafDemo
 * @Copyright (c) 2017, Lianjia Group All Rights Reserved.
 * @since 2017/6/25
 */
@Controller
public class ThemeLeafDemoController {
    @RequestMapping("/themeleaf")
    public ModelAndView themeleafDemo(ModelAndView mav) {
        mav.addObject("hello", "hello");
        mav.addObject("world", "world");
        mav.setViewName("themeleafdemo");
        return mav;
    }
}
