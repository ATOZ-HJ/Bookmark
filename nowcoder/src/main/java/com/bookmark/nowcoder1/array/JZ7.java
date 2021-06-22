package com.bookmark.nowcoder1.array;

/**
 * @author: hj
 * @date: 2021-06-11 10:25
 * @description: 斐波那契数列
 * <p>
 * 大家都知道斐波那契数列，现在要求输入一个整数n，请你输出斐波那契数列的第n项（从0开始，第0项为0，第1项是1）。
 * n≤39
 **/

public class JZ7 {

    /**
     * 运行时间：12ms
     * 超过79.52% 用Java提交的代码
     * 占用内存：9720KB
     * 超过5.00%用Java提交的代码
     *
     * @param n
     * @return
     */
    public static int Fibonacci(int n) {
        if (n == 0 || n == 1) {
            return n;
        }
        int[] array = new int[n + 1];
        array[0] = 0;
        array[1] = 1;
        for (int i = 2; i <= n; i++) {
            array[i] = array[i - 1] + array[i - 2];
        }
        return array[n];
    }

    /**
     * 官方解答1:使用递归实现，时间复杂度较高
     * 运行时间：323ms
     * 超过33.92% 用Java提交的代码
     * 占用内存：9764KB
     * 超过3.38%用Java提交的代码
     *
     * @param n
     * @return
     */
    public static int Fibonacci1(int n) {
        if (n == 0 || n == 1) {
            return n;
        }

        return Fibonacci1(n - 1) + Fibonacci1(n - 2);
    }

    public static void main(String[] args) {
        int fibonacci = Fibonacci(4);
        System.out.println("fibonacci = " + fibonacci);
    }
}
