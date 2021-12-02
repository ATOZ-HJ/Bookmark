package com.bookmark.algo.camp;

import java.util.LinkedList;

/**
 * @author: hj
 * @date: 2021-11-30 15:39
 * @description:
 *
 * <p>
 *     设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。
 *
 * push(x) —— 将元素 x 推入栈中。
 * pop() —— 删除栈顶的元素。
 * top() —— 获取栈顶元素。
 * getMin() —— 检索栈中的最小元素。
 *  
 *
 * 示例:
 *
 * 输入：
 * ["MinStack","push","push","push","getMin","pop","top","getMin"]
 * [[],[-2],[0],[-3],[],[],[],[]]
 *
 * 输出：
 * [null,null,null,null,-3,null,0,-2]
 *
 * 解释：
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.getMin();   --> 返回 -3.
 * minStack.pop();
 * minStack.top();      --> 返回 0.
 * minStack.getMin();   --> 返回 -2.
 *  
 *
 * 提示：
 *
 * pop、top 和 getMin 操作总是在 非空栈 上调用。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/min-stack
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * </p>
 **/

public class Leetcode155_1130 {

    /**
     * 存放数据的栈
     */
    private LinkedList<Integer> stack;

    /**
     * 存放最小值的栈
     */
    private LinkedList<Integer> minStack;

    public Leetcode155_1130() {
        stack = new LinkedList<>();
        minStack = new LinkedList<>();
    }

    /**
     * 1.入栈时取出最小栈顶的值进行比较
     * 2.如果最小栈顶的值
     * @param val
     */
    public void push(int val) {
        stack.push(val);
        //与最小栈栈顶元素比较大小，判断是否需要入最小栈
        if (!minStack.isEmpty()) {
            Integer minPeek = minStack.peek();
            if (val <= minPeek) {
                minStack.push(val);
            }
        }
    }

    public void pop() {
        //取出元素判断是否与最小栈的栈顶元素相同
        if (stack.isEmpty()) {
            return;
        }
        if (!minStack.isEmpty()) {
            Integer minPeek = minStack.peek();

        }
    }

    public int top() {
        //返回存放数据栈的栈顶值
        return stack.peek();
    }

    public int getMin() {
        //返回最小栈栈顶的值
        return 0;
    }
}
