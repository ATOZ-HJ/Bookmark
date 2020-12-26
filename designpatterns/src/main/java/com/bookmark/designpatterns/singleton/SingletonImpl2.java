package com.bookmark.designpatterns.singleton;

/**
 * @author: hj
 * @date: 2020-12-19 15:19
 * @description: 饿汉式 - 线程安全，但是比较消耗资源，未使用该实例时就已经创建出来了
 **/
public class SingletonImpl2 {

    private static SingletonImpl2 singletonImpl2 = new SingletonImpl2();

    private SingletonImpl2() {

    }

    public static SingletonImpl2 getInstance(){
        return singletonImpl2;
    }
}
