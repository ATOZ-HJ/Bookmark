package com.bookmark.algo.queue;

/**
 * @author hj
 * @date 2021-09-16 12:34 上午
 * @description 基于数组实现的队列
 * 1 队列的特点是 先进先出
 */
public class QueueBasedOnArray {
    /**
     * 定义数组保存队列元素
     */
    private int[] data;

    private int count;

    private int size;

    public QueueBasedOnArray(int size) {
        this.data = new int[size];
        this.count = 0;
        this.size = size;
    }

    /**
     * 入队
     */
    public void enQueue(int num) {
        
    }
}
