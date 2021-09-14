package com.bookmark.algo.stack;

/**
 * @author: hj
 * @date: 2021-09-14 18:55
 * @description: 基于链表实现栈 1.实现一个内部类来表示链表 2.定义栈的push 和 pop方法
 **/

public class StackBasedOnLinkedList {
    /**
     * 栈顶
     */
    private Node top = null;

    /**
     * 入栈
     * 
     * @param value
     */
    public void push(int value) {
        Node newNode = new Node(value, null);
        // 判断栈是否为空
        if (top == null) {
            top = newNode;
        } else {
            newNode.next = top;
            top = newNode;
        }
    }

    /**
     * 取出一个元素
     * 
     * @return
     */
    public int pop() {
        if (top == null) {
            // 这里定义-1表示异常情况
            return -1;
        }
        int data = top.data;
        top = top.next;
        return data;
    }

    public void printAll() {
        Node s = top;
        if (s != null) {
            System.out.print(s.data + " ");
            s = s.next;
        }
        System.out.println();
    }

    private static class Node {
        private int data;
        private Node next;

        public Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }

        public int getData() {
            return data;
        }
    }
}
