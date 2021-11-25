package com.book.developtest;

import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListeningExecutorService;
import com.google.common.util.concurrent.MoreExecutors;
import org.apache.commons.lang.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author: hj
 * @date: 2021-11-17 14:48
 * @description:
 **/
public class DevTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //创建线程池
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        ListeningExecutorService pool = MoreExecutors.listeningDecorator(executorService);

        //创建异步任务
        long startTime = System.currentTimeMillis();
        List<ListenableFuture<String>> tasks = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            ListenableFuture<String> task =pool.submit(() -> {
                Thread.sleep(5000);
                System.out.println("开启了一个线程");
                return "a";
            });
            tasks.add(task);
        }
        StringBuffer sb = new StringBuffer();
        for (ListenableFuture<String> task : tasks) {
            sb.append(task.get());
        }
        System.out.println("结果:" + sb.toString());
        long endTime = System.currentTimeMillis();

        System.out.println("耗时:" + (endTime - startTime));


        //回调

    }


}
