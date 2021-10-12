package com.bookmark.algo.leetcode;

import java.util.LinkedList;

/**
 * @author: hj
 * @date: 2021-10-11 09:04
 * @description: 用两个栈实现队列
 *               <p>
 *               用两个栈实现一个队列。队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead
 *               ，分别完成在队列尾部插入整数和在队列头部删除整数的功能。(若队列中没有元素，deleteHead 操作返回 -1 ) 示例 1：
 *
 *               输入： ["CQueue","appendTail","deleteHead","deleteHead"] [[],[3],[],[]] 输出：[null,null,3,-1] 示例 2：
 *
 *               输入： ["CQueue","deleteHead","appendTail","appendTail","deleteHead","deleteHead"] [[],[],[5],[2],[],[]]
 *               输出：[null,-1,null,null,5,2] 提示：
 *
 *               1 <= values <= 10000 最多会对 appendTail、deleteHead 进行 10000 次调用
 *
 *               来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/yong-liang-ge-zhan-shi-xian-dui-lie-lcof
 *               </p>
 **/

public class Offer09 {
    LinkedList<Integer> stackA;
    LinkedList<Integer> stackB;

    public Offer09() {
        stackA = new LinkedList<>();
        stackB = new LinkedList<>();
    }

    public void appendTail(int value) {
        stackA.push(value);
    }

    public int deleteHead() {
        // 判断b是否为空,b为空，将a中元素插入
        if (stackB.isEmpty()) {
            while (!stackA.isEmpty()) {
                stackB.push(stackA.pop());
            }
        }
        if (!stackB.isEmpty()) {
            return stackB.pop();
        } else {
            return -1;
        }
    }

}
