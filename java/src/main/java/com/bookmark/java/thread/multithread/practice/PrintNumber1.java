package com.bookmark.java.thread.multithread.practice;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author: hj
 * @date: 2022-03-11 13:37
 * @description: 设计两个线程交替打印100以内的奇数和偶数
 **/
public class PrintNumber1 {

    //需要打印的数值
    public static AtomicInteger number = new AtomicInteger(0);

    public static int i = 0;
    public static AtomicInteger count = new AtomicInteger(0);

    public static  boolean flag = true;

    /**
     * 通过while true的方式不停的刷cpu，这种方式性能比较低
     * @param args
     */
    public static void main(String[] args) {
       new Thread(()->{
           while (number.get() < 101) {
               if (flag) {
                   System.out.println(Thread.currentThread().getName() + "----" + number.getAndIncrement());
                   flag = !flag;
               }
               System.out.println(Thread.currentThread().getName() + "获取到cpu时间片" + count.getAndIncrement());
           }
       },"Thread A").start();

        new Thread(()->{
            while (i < 101) {
                if (!flag) {
                    System.out.println(Thread.currentThread().getName() + "----" + number.getAndIncrement());
                    flag = !flag;
                }
                System.out.println(Thread.currentThread().getName() + "获取到cpu时间片" + count.getAndIncrement());
            }
        },"Thread B").start();
    }

}
