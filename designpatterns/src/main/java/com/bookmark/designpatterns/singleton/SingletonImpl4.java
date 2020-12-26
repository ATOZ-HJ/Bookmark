package com.bookmark.designpatterns.singleton;

/**
 * @author: hj
 * @date: 2020-12-19 15:40
 * @description:
 * 双重检验锁 - 线程安全
 * volatile关键字防止jvm指令重排
 **/
public class SingletonImpl4 {

    private volatile static SingletonImpl4 singletonImpl4;

    private SingletonImpl4() {

    }

    public static SingletonImpl4 getInstance() {
        if (singletonImpl4 == null) {
            synchronized (SingletonImpl4.class) {//对实例化部分的代码进行加锁，相较于直接给方法加锁，提升了效率
                if (singletonImpl4 == null) {//此处if判断是为了防止多线程进入第一个if判断条件后，导致创建多个实例
                    singletonImpl4 = new SingletonImpl4();
                }
            }
        }
        return singletonImpl4;
    }

}
