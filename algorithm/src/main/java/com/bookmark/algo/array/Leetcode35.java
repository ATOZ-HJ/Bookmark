package com.bookmark.algo.array;

/**
 * @author: hj
 * @date: 2022-01-09 18:01
 * @description: 搜索插入位置
 **/

public class Leetcode35 {
    /**
     * 题目可以简化为在一个排序好了的数组中查找某一个值
     * 二分查找：
     * 1.时间复杂度： O(logn)
     * 2.关注二分查找的通用写法
     *
     * 如题 目标位置一定满足以下关系：nums[pos-1] < nums[pos] <= num[pos+1]
     * 那么题目就可以转换为在一个有序数组中查找第一个大于等于target值的元素
     *
     * @param nums
     * @param target
     * @return
     */
    public int searchInsert(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }
}
