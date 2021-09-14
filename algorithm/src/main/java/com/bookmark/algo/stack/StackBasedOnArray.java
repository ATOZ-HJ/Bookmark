package com.bookmark.algo.stack;

/**
 * @author hj
 * @date 2021-09-12 8:40 下午
 * @description 基于数组实现的栈 1.首先创建一个数组用来保存栈中的元素，数组的长度是固定的
 */
public class StackBasedOnArray {
    /**
     * 栈中保存的元素
     */
    private String[] data;

    /**
     * 栈中元素的个数
     */
    private int count;

    /**
     * 栈的大小
     */
    private int size;

    /**
     * 构造函数 构造一个固定大小的栈
     *
     * @param size
     */
    public StackBasedOnArray(int size) {
        this.data = new String[size];
        this.size = size;
        this.count = 0;
    }

    /**
     * 入栈操作
     */
    public boolean push(String str) {
        // 如果栈已经满了，则入栈失败
        if (count == size) {
            return false;
        }
        // 将元素放到count位置，count加一
        data[count] = str;
        count++;
        return true;
    }

    /**
     * 出栈
     */
    public String pop() {
        // 栈中没有元素直接返回空
        if (count == 0) {
            return null;
        }
        // 取出栈顶的元素，栈中的元素个数减少一个
        String str = data[count - 1];
        count--;
        return str;

    }

}
