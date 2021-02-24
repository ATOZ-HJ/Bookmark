package com.bookmark.datastructure;

/**
 * @author: hj
 * @date: 2021-02-24 17:23
 * @description: 数组实现队列的简单demo，一次性队列
 **/
public class ArrayQueueDemo {


    /**
     * 定义队列
     */
    class ArrayQueue {
        //队列第一个元素的前一个位置，初始的时候为-1
        private int front;
        //队列最后一个元素的下标
        private int rear;
        //队列大小
        private int size;
        //模拟队列的数组
        private int[] arr;

        //构造方法
        public ArrayQueue(int size) {
            this.arr = new int[size];
            this.front = -1;
            this.rear = -1;
        }

        //判断队列是否为空
        public boolean isEmpty() {
            return front == rear;
        }


        //判断队列是否已满
        public boolean isFull() {
            return false;
        }

        //添加元素

        //取出元素

        //查看第一个元素

        //查看队列中所有的有效元素




    }

}

