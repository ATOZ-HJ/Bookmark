package com.bookmark.datastructure;

/**
 * @author: hj
 * @date: 2021-02-25 23:52
 * @description: 为了解决 ArrayQueueDemo 中队列的不可服用性,
 * 采用环形数组来解决该问题
 *
 * 问题分析
 * 1.约定front表示第一个元素的下表
 * 2.约定rear表示最后一个元素的后一个位置
 * 3.约定队列中使用有一个位置为空,也就是rear所在的位置
 **/

public class CircleArrayQueueDemo {


    static class Queue {
        private int size;
        private int front;
        private int rear;

        public Queue(int size) {
            this.size = size;
            this.front = 0;
            this.rear = 0;
        }

    }



}
