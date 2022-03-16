package com.bookmark.java.thread.multithread.practice;

/**
 * @author: hj
 * @date: 2022-03-11 16:03
 * @description: 设计三个线程分别打印a, b, c
 **/

public class PrintLetter {
    private static Object lock = new Object();

    private static int i = 0;

    public static void main(String[] args) {
        new Thread(() -> {
            synchronized (lock) {
                while (i < 100) {
                    if (i % 3 == 0) {
                        System.out.println("A Thread print  " + "a");
                        i++;
                        lock.notifyAll();
                    } else {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }

                }
            }

        }, "A-Thread").start();

        new Thread(() -> {
            synchronized (lock) {
                while (i < 100) {
                    if (i % 3 == 1) {
                        System.out.println("B Thread print  " + "b");
                        i++;
                        lock.notifyAll();
                    } else {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }

                }
            }
        }, "B-Thread").start();

        new Thread(() -> {
            synchronized (lock) {
                while (i < 100) {
                    if (i % 3 == 2) {
                        System.out.println("C Thread print  " + "c");
                        i++;
                        lock.notifyAll();
                    } else {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }, "C-Thread").start();
    }
}
