package com.bookmark.kafka.kafkatest;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.boot.autoconfigure.kafka.ConcurrentKafkaListenerContainerFactoryConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.retry.policy.SimpleRetryPolicy;
import org.springframework.retry.support.RetryTemplate;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: hj
 * @date: 2021-12-21 17:24
 * @description:
 **/
@Configuration
public class ConsumerConfig {


    @Bean
    ConcurrentKafkaListenerContainerFactory<?, ?> kafkaListenerContainerFactory(
            ConcurrentKafkaListenerContainerFactoryConfigurer configurer,
            ObjectProvider<ConsumerFactory<Object, Object>> kafkaConsumerFactory) {
        ConcurrentKafkaListenerContainerFactory<Object, Object> factory = new ConcurrentKafkaListenerContainerFactory<>();
        configurer.configure(factory, kafkaConsumerFactory.getIfAvailable());

        factory.setRetryTemplate(retryTemplate());

        return factory;
    }

    private RetryTemplate retryTemplate() {

        RetryTemplate retryTemplate = new RetryTemplate();

        /* here retry policy is used to set the number of attempts to retry and what exceptions you wanted to try and what you don't want to retry.*/
        retryTemplate.setRetryPolicy(getSimpleRetryPolicy());

        return retryTemplate;
    }

    private SimpleRetryPolicy getSimpleRetryPolicy() {
        Map<Class<? extends Throwable>, Boolean> exceptionMap = new HashMap<>();

        // the boolean value in the map determines whether exception should be retried
//        exceptionMap.put(IllegalArgumentException.class, false);
        exceptionMap.put(Exception.class, true);

        return new SimpleRetryPolicy(3,exceptionMap,true);
    }


}
