package tech.washmore.demo.springboot.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Washmore
 * @version V1.0
 * @summary 简单的websocket小玩意
 * @Copyright (c) 2017, Lianjia Group All Rights Reserved.
 * @since 2017/7/12
 */
@Controller
public class ChatController {
    @RequestMapping("/chat")
    public String chat() {
        return "chatdemo";
    }
}
