package com.bookmark.java.juc;

import lombok.extern.slf4j.Slf4j;

/**
 * @author: hj
 * @date: 2021-08-21 18:10
 * @description:
 **/
@Slf4j
public class JoinDemo {
    public static final int SLEEP_GAP = 500;

    public static String getCurThreadName() {
        return Thread.currentThread().getName();
    }

    static class HotWaterThread extends Thread {
        public HotWaterThread() {
            super("*** 烧水 Thread ***");
        }

        @Override
        public void run() {
            try {
                log.info("洗好水壶");
                log.info("灌上凉水");
                log.info("放在火上");
                //线程睡眠一段时间，模拟烧水
                Thread.sleep(SLEEP_GAP);
                log.info("水开了");
            } catch (InterruptedException e) {
                log.info("发生异常被打断 。");
            }
            log.info("运行结束 。");
        }
    }

    static class WashThread extends Thread {
        public WashThread() {
            super("$$ 清洗-Thread");
        }

        @Override
        public void run() {
            try {
                log.info("洗茶壶");
                log.info("洗茶杯");
                log.info("拿茶叶");
                Thread.sleep(SLEEP_GAP);
                log.info("洗完了");
            } catch (InterruptedException e) {
                log.info("发生异常被中断");
            }

        }
    }

    public static void main(String[] args) {
        HotWaterThread hotWaterThread = new HotWaterThread();
        WashThread washThread = new WashThread();
        hotWaterThread.start();
        washThread.start();
        try {
            hotWaterThread.join();
            washThread.join();
            Thread.currentThread().setName("主线程");
            log.info("泡茶喝");
        } catch (InterruptedException e) {
            log.info(getCurThreadName() + "发生异常被终止");
        }
        log.info(getCurThreadName() + "运行结束");
    }
}
