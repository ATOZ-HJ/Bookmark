package com.datastructure.nowcoder.array;

import java.util.HashMap;

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
     * <p>
     * 代码不够简洁
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
     * <p>
     * <p>
     * 简单递归 性能较差
     *
     * @param n
     * @return
     */
    public static int Fibonacci1(int n) {
        if (n == 0 || n == 1) {
            return n;
        }
        //使用map来保存每次的计算结果，不做重复计算
        return Fibonacci1(n - 1) + Fibonacci1(n - 2);
    }

    /**
     * <p>
     * 对重复计算问题进行了优化 ,加入map缓存，避免重复计算 ；备忘录算法
     *
     * @param n
     * @return
     */
    public static int Fibonacci2(int n, HashMap<Integer, Integer> map) {
        if (n == 0 || n == 1) {
            return n;
        }
        //使用map来保存每次的计算结果，不做重复计算
        if (map.containsKey(n)) {
            return map.get(n);
        } else {
            int value = Fibonacci2(n - 1, map) + Fibonacci2(n - 2, map);
            map.put(n, value);
            return value;
        }
    }

    /**
     * <p>
     * 使用动态规划的方式
     * 状态转移方程 : F(n) = F(n-1) + f(n+1)
     * 边界 : f(0) = 0  ;  f(1) = 1
     * 最优子结构 ： F(n-1) + f(n+1)
     * <p>
     * <p>
     * 运行时间：12ms
     * 超过79.52% 用Java提交的代码
     * 占用内存：9720KB
     * 超过5.06%用Java提交的代码
     *
     * @param n
     * @return
     */
    public static int Fibonacci3(int n) {
        if (n == 0 || n == 1) {
            return n;
        }
        int a = 0;
        int b = 1;
        int temp = 0;
        for (int i = 2; i < n + 1; i++) {
            temp = a + b;
            a = b;
            b = temp;
        }
        return temp;
    }

    public static void main(String[] args) {
//        int fibonacci = Fibonacci2(4, new HashMap<>());
        int fibonacci3 = Fibonacci3(4);
        System.out.println("fibonacci3 = " + fibonacci3);
    }
}
