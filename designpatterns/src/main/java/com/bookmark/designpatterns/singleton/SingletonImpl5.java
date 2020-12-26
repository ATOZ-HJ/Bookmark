package com.bookmark.designpatterns.singleton;

/**
 * @author: hj
 * @date: 2020-12-26 14:21
 * @description: 静态内部类实现  涉及到类加载相关的问题  延时加载，线程安全
 *
 * 1. 父类被加载的时候，SingletonHolder不会被加载，此时并不会占用内存
 * 2. 当调用getInstance方法的时候，INSTANCE  才会被初始化
 * 3. 由于jvm类加载的机制，保证了该实现的线程安全
 **/
public class SingletonImpl5 {

    private SingletonImpl5() {

    }
    private static class SingletonHolder{
        private static final SingletonImpl5 INSTANCE = new SingletonImpl5();
    }

    public static SingletonImpl5 getInstance() {
        return SingletonHolder.INSTANCE;
    }
}
