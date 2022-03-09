package com.bookmark.java.reflect.proxy.jdk;

import java.lang.reflect.Proxy;

/**
 * @author: hj
 * @date: 2022-03-09 15:32
 * @description:
 **/

public class JdkProxyFactory {
    public static Object getProxy(Object target) {
        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), new DebugInvocationHandler(target));
    }
}
