package com.bookmark.java.reflect.proxy.jdk;

/**
 * @author: hj
 * @date: 2022-03-09 15:17
 * @description:
 **/

public class SmsServiceImpl implements SmsService{
    @Override
    public String sendMsg(String msg) {
        System.out.println("send message = " + msg);
        return msg;
    }
}
