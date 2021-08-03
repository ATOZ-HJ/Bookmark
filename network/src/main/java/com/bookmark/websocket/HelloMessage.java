package com.bookmark.websocket;

/**
 * @author: hj
 * @date: 2021-08-03 16:08
 * @description:
 **/

public class HelloMessage {
    private String name;

    public HelloMessage() {
    }

    public HelloMessage(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
