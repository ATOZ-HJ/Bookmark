package com.bookmark.datastructure;

/**
 * @author: hj
 * @date: 2021-02-24 17:23
 * @description: 数组实现队列的简单demo，一次性队列
 **/
public class ArrayQueueDemo {
    public static void main(String[] args) {
        ArrayQueue queue = new ArrayQueue(3);
        System.out.println("添加第1个元素");
        queue.add(1);
        queue.show();
        System.out.println("添加第2个元素");
        queue.add(2);
        queue.show();
        System.out.println("添加第3个元素");
        queue.add(3);
        queue.show();
        int value = queue.get();
        System.out.println("value = " + value);
        int value2 = queue.get();
        System.out.println("value2 = " + value2);
        int head = queue.head();
        System.out.println("head = " + head);
        queue.get();
        boolean empty = queue.isEmpty();
        System.out.println("empty = " + empty);
    }


    /**
     * 定义队列
     */
   static class ArrayQueue {
        //队列第一个元素的前一个位置，初始的时候为-1
        private int front;
        //队列最后一个元素的下标,初始的时候为-1
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


        //判断队列是否已满 ,rear = length - 1
        public boolean isFull() {
            return this.rear == arr.length - 1;
        }

        //添加元素,rear+1
        public void add(int value) {
            if (isFull()) {
                throw new RuntimeException("队列已满");
            }
            rear++;
            arr[rear] = value;
        }

        //取出首个元素
        public int get() {
            if (isEmpty()) {
                throw new RuntimeException("队列为空");
            }
            front++;
            return arr[front];
        }

        //查看第一个元素
        public int head() {
            if (isEmpty()) {
                throw new RuntimeException("队列为空");
            }
            return arr[front+1];
        }

        //查看队列中所有的有效元素
        public void show() {
            if (isEmpty()) {
                throw new RuntimeException("队列为空");
            }
            for (int i = front+1; i <= rear; i++) {
                System.out.println(this.arr[i]);
            }
        }




    }

}

