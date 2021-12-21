package com.bookmark.kafka.kafkatest;

import cn.hutool.json.JSONUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

/**
 * @author: hj
 * @date: 2021-08-16 15:47
 * @description: Kafka生产者发送消息
 **/
@Component
@Slf4j
public class KafkaProducer {
    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    /**
     * 向指定主题发送消息
     * 
     * @param topic
     * @param message
     */
    public void sendMessage(String topic, Object message) {
        String jsonMessage = JSONUtil.toJsonStr(message);
        log.info("[kafkaProducer.sendMessage()] Kafka生产者发送内容,topic:{},message:{}", topic, jsonMessage);
        ListenableFuture<SendResult<String, String>> send = kafkaTemplate.send(topic, jsonMessage);
        sendResultCallback(topic, message, send);
    }

    /**
     * 向指定主题发送指定key的消息
     *
     * @param topic
     * @param message
     */
    public void sendMessage(String topic, String key, Object message) {
        String jsonMessage = JSONUtil.toJsonStr(message);
        log.info("[kafkaProducer.sendMessage()] Kafka生产者发送内容,topic:{},key:{},message:{}", topic, key, jsonMessage);
        ListenableFuture<SendResult<String, String>> send = kafkaTemplate.send(topic, key, jsonMessage);
        sendResultCallback(topic, message, send);
    }

    /**
     * 向指定主题发送指定key的消息 消息为解析后的json字符串
     *
     * @param topic
     * @param jsonStr
     */
    public void sendMessage(String topic, String key, String jsonStr) {
        log.info("[kafkaProducer.sendMessage()] Kafka生产者发送内容,topic:{},key:{},message:{}", topic, key, jsonStr);
        ListenableFuture<SendResult<String, String>> send = kafkaTemplate.send(topic, key, jsonStr);
        sendResultCallback(topic, jsonStr, send);
    }

    /**
     * 处理发送回调
     * 
     * @param topic
     * @param message
     * @param send
     */
    private void sendResultCallback(String topic, Object message, ListenableFuture<SendResult<String, String>> send) {
        send.addCallback(new ListenableFutureCallback<SendResult<String, String>>() {
            @Override
            public void onSuccess(SendResult<String, String> sendResult) {
                log.info("kafka消息发送成功,topic:{},message:{},发送成功:{}", topic, message, sendResult);
            }

            @Override
            public void onFailure(Throwable throwable) {
                log.error("kafka消息发送失败,topic:{},message:{},发送失败信息:{}", topic, message, throwable.toString());
            }
        });
    }
}
