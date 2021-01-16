package com.bookmark.leetcode.practice;

/**
 * @author: hj
 * @date: 2021-01-16 14:55
 * @description: 回文数
 * 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 *
 * 示例 1:
 *
 * 输入: 121
 * 输出: true
 * 示例 2:
 *
 * 输入: -121
 * 输出: false
 * 解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
 * 示例 3:
 *
 * 输入: 10
 * 输出: false
 * 解释: 从右向左读, 为 01 。因此它不是一个回文数。
 * 进阶:
 *
 * 你能不将整数转为字符串来解决这个问题吗？
 *
 **/
public class LeetCode09 {
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        //先作反转操作，参考leetCode07
        int result = 0;
        int temp = x;
        while (x != 0) {
            int pop = x % 10;
            x /= 10;
            //判断int类型大小
            if (result > Integer.MAX_VALUE / 10 || (result == Integer.MAX_VALUE/10 && pop > 7)) {
                return false;
            }
            if (result < Integer.MIN_VALUE / 10 || (result == Integer.MIN_VALUE/10 && pop < -8)) {
                return false;
            }
            result = result * 10 + pop;
        }
        return result == temp;
    }

    public static void main(String[] args) {
        LeetCode09 leetCode09 = new LeetCode09();
        boolean palindrome = leetCode09.isPalindrome(323323);
        System.out.println("palindrome = " + palindrome);
    }
}
