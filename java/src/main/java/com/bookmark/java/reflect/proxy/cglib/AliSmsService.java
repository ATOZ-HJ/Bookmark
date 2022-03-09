package com.bookmark.java.reflect.proxy.cglib;

/**
 * @author: hj
 * @date: 2022-03-09 15:59
 * @description:
 **/

public class AliSmsService {
    public String send(String msg) {
        System.out.println("sendMessage = " + msg);
        return msg;
    }
}
