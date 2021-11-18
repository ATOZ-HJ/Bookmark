package com.bookmark.algo.camp;

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
     * 双指针的方法 ：参考题解内容写出来的
     *
     * @param nums
     * @return
     */
    public static List<List<Integer>> threeSum3(int[] nums) {
        //先排序
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        //这里循环就很细致，固定k，并且有i和j两个指针，所以k<nums.length-2即可
        for (int k = 0; k < nums.length - 2; k++) {
            //如果nums[k]大于0，由于数组是排序的，后面的值更大，所以直接退出
            if (nums[k] > 0) {
                break;
            }
            //当k>0时，下标k处的值如果和上一个值相等，则直接跳过本次循环
            if (k > 0 && nums[k] == nums[k - 1]) {
                continue;
            }
            //定义左右指针
            int i = k + 1;
            int j = nums.length - 1;
            while (i < j) {
                int sum = nums[k] + nums[i] + nums[j];
                //如果sum小于0，则说明nums[i]处的数值较小，需要向右移动一位
                if (sum < 0) {
                    //这里又很巧妙了；直接修改计算sum公式中的nums[i]的引用，并且i指针还+1了
                    while (i < j && nums[i] == nums[++i]) ;
                } else if (sum > 0) {
                    //同上
                    while (i < j && nums[j] == nums[--j]) ;
                } else {
                    res.add(new ArrayList<Integer>(Arrays.asList(nums[k], nums[i], nums[j])));
                    while (i < j && nums[i] == nums[++i]) ;
                    while (i < j && nums[j] == nums[--j]) ;
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
        for (int first = 0; first < nums.length; ++first) {
            if (nums[first] > 0) {
                break;
            }
            //如果a重复则直接跳过遍历
            if (first > 0 && nums[first] == nums[first - 1]) {
                continue;
            }
            int third = nums.length - 1;
            for (int second = first + 1; second < nums.length; ++second) {
                //b也不能重复
                if (second > first + 1 && nums[second] == nums[second - 1]) {
                    continue;
                }
                //判断三数之和的大小;
                // 当三数之和小于0没有判断，直接值for循环中去递增了
                while (second < third && nums[first] + nums[second] + nums[third] > 0) {
                    --third;
                }
                if (second == third) {
                    break;
                }
                if (nums[first] + nums[second] + nums[third] == 0) {
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
