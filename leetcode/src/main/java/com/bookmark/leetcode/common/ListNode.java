package com.bookmark.leetcode.common;

import lombok.Data;

/**
 * @author: hj
 * @date: 2021-04-18 16:28
 * @description: 定义一个链表节点
 **/
@Data
public class ListNode {
    public int val;
    public ListNode next;


    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }


}
