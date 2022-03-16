package com.bookmark.java.thread.multithread.practice;

/**
 * @author: hj
 * @date: 2022-03-11 14:00
 * @description: 设计两个线程交替打印100以内的奇数和偶数
 **/

public class PrintNumber2 {
    public static int num = 0;

    public static Object lock = new Object();

    /**
     * 使用wait和notify来通知其他线程执行
     *
     * @param args
     */
    public static void main(String[] args) {
        new Thread(() -> {
            while (num < 101) {
                //这里当前线程还是有可能拿到锁
                synchronized (lock) {
                    if (num % 2 == 1) {
                        System.out.println(Thread.currentThread().getName() + "---" + num++);
                        //执行notify，唤醒等待锁的其他线程，但是当前线程会先执行完synchronized代码块中的代码
                        //这里当前线程notify后没有进入休眠的状态，也就是说还有可能继续获得锁
                        lock.notify();
                    } else {
                        //拿到锁，但是不符合条件，直接释放锁，调用wait方法后当前线程需要等待其他锁notify
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }, "odd thread").start();
        new Thread(() -> {
            while (num < 101) {
                synchronized (lock) {
                    if (num % 2 == 0) {
                        System.out.println(Thread.currentThread().getName() + "---" + num++);
                        lock.notify();
                    } else {
                        //释放锁
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }, "even thread").start();

    }
}
