package com.bookmark.kafka.kafkatest;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.springframework.kafka.listener.BatchErrorHandler;
import org.springframework.kafka.listener.LoggingErrorHandler;
import org.springframework.kafka.listener.MessageListenerContainer;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

/**
 * @author: hj
 * @date: 2021-12-21 17:11
 * @description:
 **/
@Component
@Slf4j
public class ErrorHandler extends LoggingErrorHandler {

    @Override
    public void handle(Exception thrownException, ConsumerRecord<?, ?> record) {
        log.error("异常处理器");
    }
}
