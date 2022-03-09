package com.bookmark.java.reflect.proxy.cglib;


/**
 * @author: hj
 * @date: 2022-03-09 15:44
 * @description:
 **/

public class ProxyTest {
    public static void main(String[] args) {
        AliSmsService proxy = (AliSmsService) CglibProxyFactory.getProxy(AliSmsService.class);
        proxy.send("我用代理类发送了一条消息");
    }
}
