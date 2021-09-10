package com.datastructure.linkedlist;

/**
 * @author: hj
 * @date: 2021-03-08 22:59
 * @description: 自定义单向链表
 **/

public class SingleLinkedList {
    // 定义一个head节点
    private Node head;

    public SingleLinkedList() {
        this.head = new Node(0, "", "");
    }

    // 定义添加元素的方法
    // 每次添加到链表的尾部
    public void add(Node node) {
        // 定义一个临时变量用于遍历
        Node tmp = head;
        while (tmp.next != null) {
            tmp = tmp.next;
        }
        tmp.next = node;
    }

    // 定义查询并取出的方法，每次查询的链表head节点的下一个元素

    // 定义删除的方法

}
