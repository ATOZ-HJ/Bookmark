package com.datastructure.leetcode.practice;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author: hj
 * @date: 2021-01-12 18:59
 * @description: 两数之和
 * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 的那 两个 整数，并返回它们的数组下标。
 * <p>
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
 * <p>
 * 你可以按任意顺序返回答案。
 **/
public class LeetCode01 {
    /**
     * 时间复杂度 O(N^2)
     * 空间复杂度 O(1)
     * 时间复杂度主要是双层循环导致
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] towSum(int[] nums, int target) {
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }

    /**
     * 时间复杂度 O(N)
     * 空间复杂度 O(1)
     * 使用map可以实现快速查找的需求
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] towSum2(int[] nums, int target) {
        Map<Integer, Integer> numsMap = new HashMap<>(16);
        for (int i = 0; i < nums.length; i++) {
            if (numsMap.containsKey(target - nums[i])) {
                return new int[]{numsMap.get(target - nums[i]), i};
            }
            numsMap.put(nums[i], i);
        }
        return null;
    }

    public static void main(String[] args) {
        LeetCode01 leetCode01 = new LeetCode01();
        int[] nums = {2, 7, 11, 15};
        int[] ints = leetCode01.towSum2(nums, 9);
        System.out.println("ints = " + Arrays.toString(ints));
    }
}
