package com.bookmark.designpatterns.singleton;

/**
 * @author: hj
 * @date: 2020-12-19 14:24
 * @description: 1.懒汉式，线程不安全
 **/
public class SingletonImpl1 {


    //私有变量
    private static SingletonImpl1 singletonImpl1;

    //构造方法私有化
    private SingletonImpl1() {

    }

     //公有的静态方法
     public static SingletonImpl1 getUniqueInstance() {
        if (singletonImpl1 == null) { //此处判断线程不安全，存在创建多个实例的可能
            singletonImpl1 = new  SingletonImpl1();
        }
        return singletonImpl1;
    }

}
