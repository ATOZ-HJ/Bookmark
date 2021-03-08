package com.datastructure.array.impl;

/**
 * @author: hj
 * @date: 2021-03-08 22:19
 * @description: 循环数组实现队列
 *  1.约定front表示第一个元素的位置
 *  2.约定rear表示最后一个元素的后一个位置
 *  3.约定队列中始终有一个位置为空,也就是rear所在的位置
 **/

public class CircleArrayQueue {

    private int maxSize;

    private int front;
    private int rear;
    private int[] arr;

    public CircleArrayQueue(int maxSize) {
        this.maxSize = maxSize;
        this.front = 0;
        this.rear = 0;
        this.arr = new int[maxSize];
    }

    /**
     * 为空的判断条件是 rear==front
     *
     * @return
     */
    public boolean isEmpty() {
        return rear == front;
    }

    /**
     * 数组已满的条件是 (rear+1) % size == front
     */
    public boolean isFull() {
        return (rear + 1) % maxSize == front;
    }

    /**
     * 添加元素
     */
    public boolean add(int value) {
        if (isFull()) {
            enLarge();
        }
        arr[rear] = value;
        rear = (rear + 1) % maxSize;
        return true;
    }

    /**
     * 取出第一个元素
     */
    public int get() {
        if (isEmpty()) {
            throw new RuntimeException("新增元素失败，队列为空");
        }
        int value = arr[front];
        front = (front + 1) % maxSize;
        return value;
    }

    /**
     * 查看队列中有效元素的个数
     */
    public int getSize() {
        if (isEmpty()) {
            return 0;
        }
        return (rear + maxSize - front) % maxSize;
    }

    /**
     * 以数组的形式返回队列中的元素
     */
    public void show() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空");
        }
        int size = getSize();
        System.out.print("打印数组 : ");
        for (int i = front; i < front + size; i++) {
            System.out.print(arr[i % maxSize] + " ");
        }
        System.out.println();
    }


    /**
     * 队列扩容,将元素扩容为原来的两倍
     * 1. 创建大小为原数组两倍的新数组
     * 2. 将原数组中的元素按照先后顺寻放入到新数组中去
     * todo 扩容方法需要修改
     */

    public void enLarge() {
        int maxSizeNew = maxSize << 1;
        int[] arrNew = new int[maxSizeNew];
        int count = 0;
        int size = getSize();
        for (int i = front; i < front + size; i++) {
            arrNew[count++] = arr[i % maxSize];
        }
        //重置队列属性
        front = 0;
        rear = size;
        maxSize = maxSizeNew;
        arr = arrNew;
    }


}
