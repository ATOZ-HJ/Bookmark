package com.bookmark.java.reflect.proxy.jdk;

/**
 * @author: hj
 * @date: 2022-03-09 15:44
 * @description:
 **/

public class ProxyTest {
    public static void main(String[] args) {
        SmsService smsService = (SmsService) JdkProxyFactory.getProxy(new SmsServiceImpl());
        smsService.sendMsg("我用代理类发送了一条消息");
    }
}
