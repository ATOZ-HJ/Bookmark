package com.bookmark.java.thread.asyncallback;

import com.google.common.util.concurrent.*;
import lombok.extern.slf4j.Slf4j;
import org.checkerframework.checker.nullness.qual.Nullable;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author: hj
 * @date: 2021-08-22 14:43
 * @description:
 **/
@Slf4j
public class GuavaFutureDemo {


    public static final int SLEEP_GAP = 500;

    public static String getCurThreadName() {
        return Thread.currentThread().getName();
    }

    static class HotWaterJob implements Callable<Boolean> {

        @Override
        public Boolean call() throws Exception {
            try {
                log.info("洗好水壶");
                log.info("灌上凉水");
                log.info("放在火上");
                //线程睡眠一段时间，模拟烧水
                Thread.sleep(SLEEP_GAP);
                log.info("水开了");
            } catch (InterruptedException e) {
                log.info("发生异常被打断 。");
                return false;
            }
            log.info("烧水工作运行结束 。");
            return true;
        }
    }

    static class WashJob implements Callable<Boolean> {
        @Override
        public Boolean call() throws Exception {
            try {
                log.info("洗茶壶");
                log.info("洗茶杯");
                log.info("拿茶叶");
                Thread.sleep(SLEEP_GAP);
                log.info("洗完了");
            } catch (InterruptedException e) {
                log.info("发生异常被中断");
                return false;
            }
            log.info("洗茶具工具结束");
            return true;
        }
    }

    /**
     * 创建一个主任务
     */
    static class MainJob implements Runnable {
        boolean waterOk = false;
        boolean cupOk = false;
        int gap = SLEEP_GAP / 10;

        @Override
        public void run() {
            while (true) {
                try {
                    Thread.sleep(gap);
                    log.info("读书中");
                } catch (InterruptedException e) {
                    log.info("发生异常，操作中断");
                }
                if (waterOk && cupOk) {
                    drinkTea(waterOk, cupOk);
                }
            }

        }

        private void drinkTea(boolean hotOk, boolean washOk) {
            if (hotOk && washOk) {
                log.info("泡茶喝");
            } else if (!hotOk) {
                log.info("烧水失败，没茶喝");
            } else if (!washOk) {
                log.info("清洗失败，没茶喝");
            }
        }
    }


    public static void main(String[] args) {
        //创建一个主线程用于泡茶线程
        MainJob mainJob = new MainJob();
        Thread mainThread = new Thread(mainJob);
        mainThread.setName("主线程");
        mainThread.start();

        //烧水
        HotWaterJob hotWaterJob = new HotWaterJob();
        //清洗
        WashJob washJob = new WashJob();

        //创建Java线程池
        ExecutorService jPool = Executors.newFixedThreadPool(10);
        //构造guava线程池
        ListeningExecutorService gPool = MoreExecutors.listeningDecorator(jPool);

        //提交烧水任务
        ListenableFuture<Boolean> hotFuture = gPool.submit(hotWaterJob);

        //提交清洗任务
        ListenableFuture<Boolean> washFuture = gPool.submit(washJob);

        //绑定烧水任务的异步回调
        Futures.addCallback(hotFuture, new FutureCallback<Boolean>() {
            @Override
            public void onSuccess(@Nullable Boolean result) {
                if (result) {
                    mainJob.waterOk = true;
                }
            }

            @Override
            public void onFailure(Throwable t) {
                log.info("烧水失败了");
            }
        }, gPool);

        //清洗任务的异步回调
        Futures.addCallback(washFuture, new FutureCallback<Boolean>() {
            @Override
            public void onSuccess(@Nullable Boolean result) {
                if (result) {
                    mainJob.cupOk = true;
                }
            }

            @Override
            public void onFailure(Throwable t) {
                log.info("清洗失败了");
            }
        }, gPool);


    }


}
