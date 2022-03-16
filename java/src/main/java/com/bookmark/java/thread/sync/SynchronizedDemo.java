package com.bookmark.java.thread.sync;

/**
 * @author hj
 * @date 2022-03-16 8:44 下午
 * @description
 */
public class SynchronizedDemo {
    public void method() {
        synchronized (this) {
            System.out.println("synchronized 代码块");
        }
    }

    public synchronized void method2() {
        System.out.println("synchronized 代码块2");
    }
}
