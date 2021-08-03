package com.bookmark.websocket;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: hj
 * @date: 2021-08-03 17:01
 * @description:
 **/
@RestController
public class TestController {
    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate;

    @GetMapping("/test")
    public void test() throws Exception {
        String name = "test中的名称";
        simpMessagingTemplate.convertAndSend("/topic/greetings", name);
    }
}
