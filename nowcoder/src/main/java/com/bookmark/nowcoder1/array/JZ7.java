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
    public static int Fibonacci(int n) {
        if (n == 0 || n == 1) {
            return n;
        }

        int[] array = new int[39];
        array[0] = 0;
        array[1] = 1;
        for (int i = 2; i <= n; i++) {
            array[i] = array[i - 1] + array[i - 2];
        }

        return array[n];
    }

    public static void main(String[] args) {
        int fibonacci = Fibonacci(4);
        System.out.println("fibonacci = " + fibonacci);
    }
}
