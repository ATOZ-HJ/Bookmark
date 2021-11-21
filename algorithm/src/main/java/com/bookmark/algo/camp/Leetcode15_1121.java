package com.bookmark.algo.camp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author hj
 * @date 2021-11-17 11:09 下午
 * @description : 三数之和 https://leetcode-cn.com/problems/3sum
 * <p>
 */
public class Leetcode15_1121 {
    /**
     * 使用了三层for循环的方式，这种方式包含了很多的重复解，所以需要保持不重复，我们可以
     * 这个方法就是我们常说的「双指针」，当我们需要枚举数组中的两个元素时，如果我们发现随着第一个元素的递增，第二个元素是递减的，那么就可以使用双指针的方法
     *
     * @param nums
     * @return
     */
    public static List<List<Integer>> threeSum(int[] nums) {
        //对数组进行排序 ，排序后元素为从大到小
        Arrays.sort(nums);

        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            //如果a大于0 ,则直接退出循环，由排序后数组---> 0<a<=b<=c
            int a = nums[i];
            if (a > 0) {
                break;
            }

            //当 i > 0时判断 nums[i]==nums[i-1]，避免重复解
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            //定义左右指针j 和k
            int j = i + 1;
            int k = nums.length - 1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                //判断 nums[j]==nums[j-1]
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    j++;
                    continue;
                }
                //判断 判断 nums[k]==nums[k+1]
                if (k < nums.length - 1 && nums[k] == nums[k + 1]) {
                    k--;
                    continue;
                }

                //判断三数之和
                if (nums[i] + nums[j] + nums[k] == 0) {
                    res.add(Arrays.asList(nums[i], nums[j++], nums[k--]));
                } else if (sum < 0) {
                    //如果sum小于0，说明 b的值小了，则j++
                    j++;
                } else if (sum > 0) {
                    //如果sum大于0，说明 c的值大了，则k--
                    k--;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        final List<List<Integer>> lists = threeSum(new int[]{0, 0, 0, 0});
        System.out.println("lists = " + lists);
    }
}
