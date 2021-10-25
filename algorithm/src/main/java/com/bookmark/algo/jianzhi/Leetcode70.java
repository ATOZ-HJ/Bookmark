package com.bookmark.algo.jianzhi;

/**
 * @author: hj
 * @date: 2021-10-24 11:20
 * @description: 爬楼梯
 * <p>
 * 假设你正在爬楼梯。需要 n阶你才能到达楼顶。
 * <p>
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 * <p>
 * 注意：给定 n 是一个正整数。
 * <p>
 * 示例 1：
 * <p>
 * 输入： 2
 * 输出： 2
 * 解释： 有两种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶
 * 2.  2 阶
 * 示例 2：
 * <p>
 * 输入： 3
 * 输出： 3
 * 解释： 有三种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶 + 1 阶
 * 2.  1 阶 + 2 阶
 * 3.  2 阶 + 1 阶
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/climbing-stairs
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/

public class Leetcode70 {
    /**
     * 递归的方式，没有缓存的话时间复杂度度高.O(2^n)
     *
     * @return
     * @paramn
     */
    public static int climbStairs1(int n) {
        if (n < 3) return n;
        return climbStairs1(n - 2) + climbStairs1(n - 1);
    }


    /**
     * for 循环的方式，每次只保存最近的两个值
     *
     * @return
     * @paramn
     */
    public static int climbStairs2(int n) {
        if (n < 3) {
            return n;
        }
        int f1 = 1;
        int f2 = 2;
        int f3 = 0;
        for (int i = 3; i < n + 1; i++) {
            f3 = f1 + f2;
            f1 = f2;
            f2 = f3;
        }
        return f3;
    }

    public static void main(String[] args) {
        final int i = climbStairs2(4);
        System.out.println("i = " + i);
    }

}
