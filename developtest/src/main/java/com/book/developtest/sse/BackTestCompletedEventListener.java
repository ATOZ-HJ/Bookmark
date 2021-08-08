package com.book.developtest.sse;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author: hj
 * @date: 2021-08-03 10:03
 * @description:
 **/
@Component
public class BackTestCompletedEventListener {
    private static Map<String, SseEmitter> sseEmitters = new ConcurrentHashMap<>();

    @EventListener
    public void eventHandler(BackTestCompletedEvent event) throws IOException {
        String backTestId = event.getBackTestId();
        SseEmitter sseEmitter = sseEmitters.get(backTestId);
        sseEmitter.send(backTestId);
//        sseEmitter.complete();
        //
    }

    public void addSseEmitters(String payRecordId, SseEmitter sseEmitter) {
        sseEmitters.put(payRecordId, sseEmitter);
    }
}
