package com.bookmark.kafka.kafkatest;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

/**
 * @author: hj
 * @date: 2021-08-16 11:29
 * @description:
 **/
@Component
public class KafkaConsumer {
    @KafkaListener(topics = {"topic1"})
    public void onMessage1(ConsumerRecord<?, ?> record) {

        String key = (String) record.key();
        
        System.out.println("key = " + key);
        // 消费的哪个topic、partition的消息,打印出消息内容
        System.out.println("简单消费：" + record.topic() + "-" + record.partition() + "-" + record.value());
    }

}
