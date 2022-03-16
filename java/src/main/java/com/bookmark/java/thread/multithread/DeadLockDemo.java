package com.bookmark.java.thread.multithread;

/**
 * @author: hj
 * @date: 2022-03-15 20:38
 * @description: 死锁的demo
 **/
public class DeadLockDemo {

    private static Object resource1 = new Object();
    private static Object resource2 = new Object();
    public static void main(String[] args) {
        //创建一个线程
        new Thread(() -> {
            synchronized (resource1) {
                System.out.println(Thread.currentThread().getName() + "  获取的resource1");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + " 等待获取resource2");
                synchronized (resource2) {
                    System.out.println(Thread.currentThread().getName() + " 获取的resource2");
                }
            }
        }, "Thread1").start();

        new Thread(() -> {
            synchronized (resource2) {
                System.out.println(Thread.currentThread().getName() + "  获取的resource2");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + " 等待获取resource1");
                synchronized (resource1) {
                    System.out.println(Thread.currentThread().getName() + " 获取的resource1");
                }
            }
        }, "Thread2").start();
    }
}
