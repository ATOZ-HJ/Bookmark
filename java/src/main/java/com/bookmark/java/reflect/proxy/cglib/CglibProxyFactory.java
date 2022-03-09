package com.bookmark.java.reflect.proxy.cglib;


import net.sf.cglib.proxy.Enhancer;

/**
 * @author: hj
 * @date: 2022-03-09 16:05
 * @description:
 **/

public class CglibProxyFactory {
    public static Object getProxy(Class<?> clazz) {
        Enhancer enhancer = new Enhancer();
        enhancer.setClassLoader(clazz.getClassLoader());
        enhancer.setSuperclass(clazz);
        enhancer.setCallback(new DebugMethodInterceptor());
        return enhancer.create();
    }
}
