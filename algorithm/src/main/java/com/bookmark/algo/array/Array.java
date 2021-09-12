package com.bookmark.algo.array;

/**
 * @author: hj
 * @date: 2021-09-12 14:53
 * @description: 定义一个int类型的数组；并且定义这个数组的删除、插入、按照下标访问的操作
 **/

public class Array {
    /**
     * 定义整型的数组数据
     */
    private int[] data;

    /**
     * 定义数组的长度
     */
    private int n;

    /**
     * 定义数组中元素的个数
     */
    private int count;

    /**
     * 构造函数
     * 
     * @param capacity
     */
    public Array(int capacity) {
        this.data = new int[capacity];
        this.n = capacity;
        this.count = 0;
    }

    public int add(int index, int num) {
        if (index < 0 || index > count - 1) {
            return -1;
        }
        if (count == n) {
            return -1;
        }

    }

    /**
     * 数组元素的删除操作
     * 
     * @param index
     * @return
     */
    public boolean delete(int index) {
        if (index < 0 || index > count - 1) {
            return false;
        }
        // 删除后，index后的元素向前移动一位
        for (int i = index; i < count - 1; i++) {

        }
    }

}
