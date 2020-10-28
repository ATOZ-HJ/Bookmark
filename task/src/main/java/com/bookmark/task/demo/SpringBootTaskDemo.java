package com.bookmark.task.demo;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @Author: hj
 * @DateTime: 2020/10/21 18:33
 * @Description:
 */
//@Component
public class SpringBootTaskDemo {
    private int count=0;

    @Scheduled(cron="*/6 * * * * ?")
    private void process() {
        System.out.println("this is scheduler task runing  "+(count++));
    }
}
