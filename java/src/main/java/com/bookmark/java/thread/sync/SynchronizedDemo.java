package com.bookmark.java.thread.sync;

/**
 * @author: hj
 * @date: 2022-03-16 11:03
 * @description:
 **/
public class SynchronizedDemo {
    public void method() {
        synchronized (this) {
            System.out.println("synchronized 代码块");
        }
    }
}
