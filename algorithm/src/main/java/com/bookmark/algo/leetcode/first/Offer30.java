package com.bookmark.algo.leetcode.first;

import java.util.LinkedList;

/**
 * @author: hj
 * @date: 2021-10-12 17:15
 * @description: 剑指 Offer 30. 包含min函数的栈
 * <p>
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈的最小元素的 min 函数在该栈中，调用 min、push 及 pop 的时间复杂度都是 O(1)。
 * <p>
 *  
 * <p>
 * 示例:
 * <p>
 * MinStack minStack = new MinStack(); minStack.push(-2); minStack.push(0); minStack.push(-3);
 * minStack.min(); --> 返回 -3. minStack.pop(); minStack.top(); --> 返回 0. minStack.min(); --> 返回 -2.  
 * <p>
 * 提示：
 * <p>
 * 各函数的调用总次数不超过 20000 次
 * <p>
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/bao-han-minhan-shu-de-zhan-lcof
 * </p>
 **/

public class Offer30 {
    /**
     * 使用两个栈来实现，栈正常保存数值，B栈在
     */
    LinkedList<Integer> stackA;
    //B从栈顶到栈底元素从小到大，最小值可能有多个，但都在栈顶
    LinkedList<Integer> stackB;

    /**
     * initialize your data structure here.
     */
    public Offer30() {
        stackA = new LinkedList<>();
        stackB = new LinkedList<>();
    }

    /**
     * 1. 直接推入A栈中 2.与B栈顶元素进行比较，如果小于B栈顶元素，则推入B栈
     *
     * @param x
     */
    public void push(int x) {
        stackA.push(x);
        // !!! 注意这里需要判断入参与B栈顶元素是否相等，如果相等也需要推入B栈中，如果不推入B栈，则A栈出栈操作中，B栈中重复的最小值可能会弹出
        if (stackB.size() == 0 || x <= stackB.peek()) {
            stackB.push(x);
        }
    }

    /**
     * 取出A中的元素要判断是否为最小值
     */
    public void pop() {
        Integer pop = stackA.pop();
        if (pop.equals(stackB.peek())) {
            stackB.pop();
        }
    }

    public int top() {
        Integer peek = stackA.peek();
        if (peek == null) {
            throw new NullPointerException();
        }
        return peek;
    }

    public int min() {
        Integer min = stackB.peek();
        if (min == null) {
            throw new NullPointerException();
        }
        return min;
    }
}
