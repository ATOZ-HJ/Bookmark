package com.bookmark.algo.array;

/**
 * @author: hj
 * @date: 2022-01-07 16:55
 * @description: 爬楼梯
 * <p>
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
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
 * </p>
 **/

public class Leetcode70 {
    /**
     * 该题核心是找到递推公式
     * f(n) = f(n-1)+f(n-2)
     *
     * @param n
     * @return
     */
    public int climbStairs(int n) {
        if (n < 3) {
            return n;
        }
        //以下方式是滚动数组，空间复杂度为O(1)
        int a = 1;
        int b = 2;
        int c = 0;
        for (int i = 3; i < n + 1; i++) {
            c = a + b;
            a = b;
            b = c;
        }
        return c;
    }

}
