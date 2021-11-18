package com.bookmark.algo.camp;

import com.bookmark.algo.array.Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author hj
 * @date 2021-11-17 11:09 下午
 * @description : 三数之和 https://leetcode-cn.com/problems/3sum
 * <p>
 * 类似的题目：两数之和，可以参考两数之和的解决方法
 * 1.暴力求解时间复杂度 n^3
 * 2.使用map来作缓存，降低时间复杂度,n^2
 */
public class Leetcode15 {


    /**
     * 暴力求解1
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum1(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            for (int i1 = i + 1; i1 < nums.length; i1++) {
                for (int i2 = i1 + 1; i2 < nums.length; i2++) {
                    if (nums[i] + nums[i1] + nums[i2] == 0) {
                        list.add(Arrays.asList(nums[i], nums[i1], nums[i2]));
                    }
                }
            }
        }
        return list;
    }

    /**
     * 暴力求解2
     * <p>
     * 1中的方法无法去掉重复结果，所以先对数组进行排序，然后再比较
     * <p>
     * 代码运行超过要求
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum2(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            for (int i1 = i + 1; i1 < nums.length; i1++) {
                if (i1 > i + 1 && nums[i1] == nums[i1 - 1]) {
                    continue;
                }
                for (int i2 = i1 + 1; i2 < nums.length; i2++) {
                    if (i2 > i1 + 1 && nums[i2] == nums[i2 - 1]) {
                        continue;
                    }
                    if (nums[i] + nums[i1] + nums[i2] == 0) {
                        list.add(Arrays.asList(nums[i], nums[i1], nums[i2]));
                    }
                }
            }
        }
        return list;
    }

    /**
     * 双指针的方法
     *
     * @param nums
     * @return
     */
    public static List<List<Integer>> threeSum3(int[] nums) {
        //先排序
        Arrays.sort(nums);
        //固定指针k，另外两个指针 i 和 j 分别从 (k,nums.length)向中间移动

        //当num[k]>0 则直接跳过，因为数组已经排序，nums[k]>=nums[i]>=nums[j],所以nums[k]>0是，得不到三数之和=0

        //当k>0,如果nums[k]==nums[k-1]，则跳过本次循环，避免产生重复的组合
        //记s = nums[k]+nums[i]+nums[j],如果s<0,则说明nums[i]小了，则i++;如果s>0,则说明nums[j]大了，则j--

        List<List<Integer>> res = new ArrayList<>();
        for (int k = 0; k < nums.length; k++) {
            if (nums[k] > 0) {
                break;
            }
            if (k > 0 && nums[k] == nums[k - 1]) {
                continue;
            }
            int j = nums.length - 1;
            int i = k + 1;
            while (i < j) {
                int s = nums[k] + nums[i] + nums[j];
                if (s == 0) {
                    List<Integer> list = new ArrayList<>(Arrays.asList(nums[k], nums[i], nums[j]));
                    res.add(list);
                    i++;
                    j--;
                }
                if (s > 0) {
                    j--;
                }
                if (s < 0) {
                    i++;
                }
                if (i > k + 1 && nums[i] == nums[i - 1]) {
                    continue;
                }
                if (j < nums.length - 1 && nums[j] == nums[j + 1]) {
                    continue;
                }
            }
        }
        return res;
    }

    /**
     * 双指针的方法
     *
     * @param nums
     * @return
     */
    public static List<List<Integer>> threeSum4(int[] nums) {
        //先排序
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();


        //先遍历a
        for (int first = 0; first < nums.length; first++) {
            //如果a重复则直接跳过遍历
            if (first > 0 && nums[first] == nums[first - 1]) {
                continue;
            }
            int third = nums.length - 1;
            for (int second = first + 1; second < nums.length; second++) {
                //b也不能重复
                if (second > first + 1 && nums[second] == nums[second - 1]) {
                    continue;
                }
                //判断s的大小
                int s = nums[first] + nums[second] + nums[third];
                if (second < third && s > 0) {
                    third--;
                }
                if (second < third && s < 0) {
                    second++;
                }
                if (s == 0) {
                    List<Integer> list = new ArrayList<>(Arrays.asList(nums[first], nums[second], nums[third]));
                    res.add(list);
                }
            }

        }
        return res;
    }

    public static void main(String[] args) {
        List<List<Integer>> lists = threeSum3(new int[]{-1, 0, 1, 2, -1, -4});
        System.out.println("lists = " + lists);
    }

}
