package com.bookmark.sse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import javax.servlet.http.HttpServletResponse;

/**
 * @author: hj
 * @date: 2021-08-03 09:38
 * @description:
 **/
@RestController
public class SseController {


    @Autowired
    private ApplicationContext applicationContext;

    @Autowired
    BackTestCompletedEventListener listener;

    @GetMapping("/listen")
    public SseEmitter listen(@RequestParam("backTestId") String backTestId, HttpServletResponse response) {
        response.setHeader("Content-Type", "text/event-stream;charset=UTF-8");
        response.setHeader("Cache-Control", "no-cache");
        response.setHeader("Connection", "keep-alive");
        response.setHeader("Access-Control-Allow-Origin", "*");
        SseEmitter sseEmitter = new SseEmitter(0L);
        try {
            listener.addSseEmitters(backTestId, sseEmitter);

        } catch (Exception e) {
            sseEmitter.completeWithError(e);
        }
        return sseEmitter;
    }

    @GetMapping("/test")
    public String test(@RequestParam("backTestId") String backTestId, HttpServletResponse response) {
        applicationContext.publishEvent(new BackTestCompletedEvent(this, backTestId));
        return "已发送，请查看监听消息";
    }

}
