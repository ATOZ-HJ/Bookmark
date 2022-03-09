package com.bookmark.java.reflect.proxy.cglib;


import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author: hj
 * @date: 2022-03-09 15:59
 * @description:
 **/

public class DebugMethodInterceptor implements MethodInterceptor {
    @Override
    public Object intercept(Object o, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        System.out.println("before method " + method.getName());
        Object result = methodProxy.invokeSuper(o, args);
        System.out.println("after method " + method.getName());
        return result;
    }
}
