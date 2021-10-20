package com.bookmark.algo.leetcode.first;

import java.util.Arrays;
import java.util.Stack;

/**
 * @author: hj
 * @date: 2021-10-13 21:35
 * @description: 剑指 Offer 06. 从尾到头打印链表
 *               <p>
 *               输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
 *               <p>
 *                
 *               <p>
 *               示例 1：
 *               <p>
 *               输入：head = [1,3,2] 输出：[2,3,1]  
 *               <p>
 *               限制：
 *               <p>
 *               0 <= 链表长度 <= 10000
 *               <p>
 *               来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/cong-wei-dao-tou-da-yin-lian-biao-lcof
 *               著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *               </p>
 **/

public class Offer06 {
    public static int[] reversePrint(ListNode head) {
        // 循环链表，将链表的元素放到一个栈中，然后遍历栈
        Stack<Integer> stack = new Stack<>();

        while (head != null) {
            int val = head.val;
            head = head.next;
            stack.push(val);
        }
        int size = stack.size();
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = stack.pop();
        }
        System.out.println(Arrays.toString(arr));

        return arr;
    }

    // Definition for singly-linked list.
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode node1 = new ListNode(3);
        ListNode node2 = new ListNode(2);

        head.next = node1;
        node1.next = node2;
        reversePrint(head);
    }

}