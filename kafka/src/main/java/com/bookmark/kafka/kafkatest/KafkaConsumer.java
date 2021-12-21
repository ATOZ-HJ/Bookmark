package com.bookmark.kafka.kafkatest;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author: hj
 * @date: 2021-08-16 11:29
 * @description:
 **/
@Component
@Slf4j
public class KafkaConsumer {

    @KafkaListener(topics = {"test_comsume"})
    public void comsumeTestBatch2(List<ConsumerRecord<?, ?>> recordList) {
        for (ConsumerRecord<?, ?> record : recordList) {
            String messageInfo = (String) record.value();
            int i = 1 / 0;
            log.info("消息内容:{}", messageInfo);
        }
    }

}
