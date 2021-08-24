package com.datastructure.leetcode.common;

/**
 * @author: hj
 * @date: 2021-04-18 16:47
 * @description: 数据结构工具类
 **/

public class DataStructureUtil {

    /**
     * 获取一个单向链表
     * head -> 32 -> 71 -> 21 -> 2 -> 83
     *
     * @return
     */
    public static ListNode getASingleLinkedList() {
        ListNode node83 = new ListNode(83, null);
        ListNode node2 = new ListNode(2, node83);
        ListNode node21 = new ListNode(21, node2);
        ListNode node71 = new ListNode(71, node21);
        ListNode node32 = new ListNode(32, node71);
        ListNode head = new ListNode(0, node32);
        return head;
    }


}
