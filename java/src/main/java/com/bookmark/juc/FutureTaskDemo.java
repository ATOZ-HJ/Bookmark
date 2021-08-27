package com.bookmark.juc;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author: hj
 * @date: 2021-08-22 14:21
 * @description:
 **/
@Slf4j
public class FutureTaskDemo {


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


    public static void main(String[] args) {
        FutureTaskDemo.HotWaterJob hotWaterJob = new FutureTaskDemo.HotWaterJob();
        FutureTask<Boolean> hotWaterFutureTask = new FutureTask<>(hotWaterJob);
        Thread hThread = new Thread(hotWaterFutureTask, "烧水-thread");

        FutureTaskDemo.WashJob washJob = new FutureTaskDemo.WashJob();
        FutureTask<Boolean> washFutureTask = new FutureTask<>(washJob);
        Thread wThread = new Thread(washFutureTask, "清晰-thread");

        hThread.start();
        wThread.start();

        Thread.currentThread().setName("主线程");
        try {
            Boolean hotOk = hotWaterFutureTask.get();
            Boolean washOk = washFutureTask.get();
            drinkTea(hotOk, washOk);
        } catch (InterruptedException e) {
            log.info(getCurThreadName() + "发生异常");
        } catch (ExecutionException e) {
            log.info(getCurThreadName() + "发生异常被终止");
        }
    }

    private static void drinkTea(Boolean hotOk, Boolean washOk) {

        if (hotOk && washOk) {
            log.info("泡茶喝");
        } else if (!hotOk) {
            log.info("烧水失败，没茶喝");
        } else if (!washOk) {
            log.info("清洗失败，没茶喝");
        }
    }


}
