package com.bookmark.java.thread.threadpool;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author: hj
 * @date: 2022-03-17 16:36
 * @description:
 **/

public class ThreadPoolExecutorDemo {
    private static final int CORE_POOL_SIZE = 5;
    private static final int MAX_POOL_SIZE = 5;
    private static final int QUEUE_CAPACITY = 5;
    private static final long KEEP_ALIVE_TIME = 5;

    public static void main(String[] args) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(CORE_POOL_SIZE, MAX_POOL_SIZE, KEEP_ALIVE_TIME, TimeUnit.SECONDS, new ArrayBlockingQueue<>(QUEUE_CAPACITY), new ThreadPoolExecutor.CallerRunsPolicy());
        for (int i = 0; i < 10; i++) {

            MyRunnable myRunnable = new MyRunnable("" + i);
            threadPoolExecutor.execute(myRunnable);

        }
        threadPoolExecutor.shutdown();
        System.out.println("Finished all threads");

    }

}
