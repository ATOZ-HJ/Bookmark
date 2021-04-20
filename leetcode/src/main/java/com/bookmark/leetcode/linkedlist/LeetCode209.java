package com.bookmark.leetcode.linkedlist;

import com.bookmark.leetcode.common.DataStructureUtil;
import com.bookmark.leetcode.common.ListNode;

/**
 * @author: hj
 * @date: 2021-04-18 16:26
 * @description: 链表反转
 * 反转一个单链表。
 * <p>
 * 示例:
 * <p>
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 * 进阶:
 * 你可以迭代或递归地反转链表。你能否用两种方法解决这道题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-linked-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/

public class LeetCode209 {

    public static ListNode reverseList(ListNode head) {
        ListNode cur = head;
        ListNode pre = null;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    public static void main(String[] args) {
        ListNode head = DataStructureUtil.getASingleLinkedList();
        System.out.println("head = " + head);
        ListNode newHead = reverseList(head);
        System.out.println("newHead = " + newHead);
    }
}
