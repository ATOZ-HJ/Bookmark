package com.bookmark.designpatterns.singleton;

/**
 * @author: hj
 * @date: 2020-12-19 15:37
 * @description: 懒汉式 - 线程安全，对方法加锁
 **/
public class SingletonImpl3 {
    private static SingletonImpl3 singletonImpl3;

    private SingletonImpl3() {

    }

    public static synchronized SingletonImpl3 getInstance() { //在方法上加锁，确保线程安全，但是加入锁后，性能下降，不推荐
        if (singletonImpl3 == null) {
            singletonImpl3 = new SingletonImpl3();
        }
        return singletonImpl3;
    }

}
