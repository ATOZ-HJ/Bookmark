package com.bookmark.kafka.kafkatest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: hj
 * @date: 2021-08-16 11:15
 * @description:
 **/
@RestController
public class KafkaController {
    @Autowired
    private KafkaProducer kafkaProducer;


    @GetMapping("/kafka/normal/{message}")
    public void sendMessage1(@PathVariable("message") String normalMessage) {
        kafkaProducer.sendMessage("test_comsume","test1");
    }
}
