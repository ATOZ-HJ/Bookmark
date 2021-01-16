package com.bookmark.leetcode.practice;

/**
 * @author: hj
 * @date: 2021-01-13 08:48
 * @description: 整数反转
 * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 * <p>
 * 注意：
 * <p>
 * 假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−231,  231 − 1]。请根据这个假设，如果反转后整数溢出那么就返回 0。
 **/
public class LeetCode07 {
    /**
     * 该方法是初始答案，存在值溢出问题
     *
     * @param x
     * @return
     */
    public int reverse(int x) {
        int temp = x;
        int result = 0;
        while (true) {
            int a = temp / 10;
            int b = temp % 10;
            result = result * 10 + b;
            temp = a;
            if (a == 0) {
                break;
            }
        }
        return result;
    }

    /**
     * 优化
     *
     * @param x
     * @return
     */
    public int reverse1(int x) {
        int result = 0;
        while (x != 0) {
            //每次取出个位数
            int b = x % 10;
            x = x / 10;
            //以下是对result值范围的判断，int 值范围  [-2147483648,2147483647]  , -2^31 ~ 2^31 - 1
            //以后做题过程中要重视 题目提示的限制条件信息
            if (result > Integer.MAX_VALUE / 10 || (result == Integer.MAX_VALUE / 10 && b > 7)) return 0;
            if (result < Integer.MIN_VALUE / 10 || (result == Integer.MIN_VALUE / 10 && b < -8)) return 0;
            result = result * 10 + b;
        }
        return result;
    }

    public int reverseAnswer(int x) {
        int rev = 0;
        while (x != 0) {
            int pop = x % 10;
            x /= 10;
            if (rev > Integer.MAX_VALUE / 10 || (rev == Integer.MAX_VALUE / 10 && pop > 7)) return 0;
            if (rev < Integer.MIN_VALUE / 10 || (rev == Integer.MIN_VALUE / 10 && pop < -8)) return 0;
            rev = rev * 10 + pop;
        }
        return rev;
    }

    public static void main(String[] args) {
        LeetCode07 leetCode07 = new LeetCode07();
        int reverse = leetCode07.reverseAnswer(-2147483412);
        System.out.println("reverse = " + reverse);
    }
}
