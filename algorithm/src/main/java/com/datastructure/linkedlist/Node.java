package com.datastructure.linkedlist;

/**
 * @author: hj
 * @date: 2021-03-08 22:54
 * @description: 自定义一个节点
 **/

public class Node {
    public int no;
    public String name;
    public String nickName;
    public Node next;

    public Node(int no, String name, String nickName) {
        this.no = no;
        this.name = name;
        this.nickName = nickName;
    }

}
