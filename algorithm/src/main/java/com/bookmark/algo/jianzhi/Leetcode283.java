package com.bookmark.algo.jianzhi;

import java.util.Arrays;

/**
 * @author: hj
 * @date: 2021-10-23 13:26
 * @description: 移动零
 * <p>
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 * <p>
 * 示例:
 * <p>
 * 输入: [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 * 说明:
 * <p>
 * 必须在原数组上操作，不能拷贝额外的数组。
 * 尽量减少操作次数。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/move-zeroes
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * </p>
 **/

public class Leetcode283 {
    /**
     * 注意自顶向下的变成方式
     *
     * @param nums
     */
    public static void moveZeroes(int[] nums) {
        //1.创建一个指针，这个指针左侧都是非0的元素，右侧到index的之间为0
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[j] = nums[i];
                if (i != j) {
                    nums[i] = 0;
                }
                j++;
            }
        }
        System.out.println("nums = " + Arrays.toString(nums));

    }


    /**
     * 注意自顶向下的变成方式
     *
     * @param nums
     */
    public static void moveZeroes2(int[] nums) {
        //1.loop，指定j指针表示非0的元素
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[j++] = nums[i];
            }
        }
        //循环结束后在将 j 指针之后的元素置为 0
        for (int i = j; i < nums.length; i++) {
            nums[i] = 0;
        }

        System.out.println("nums = " + Arrays.toString(nums));

    }

    /**
     * 注意自顶向下的变成方式
     *
     * @param nums
     */
    public static void moveZeroes3(int[] nums) {
        //创建两个指针
        int left = 0;
        int right = 0;
        int length = nums.length;
        while (right < length) {
            if (nums[right] != 0) {
                //交换左右指针元素
                swap(right, left, nums);
                left++;
            }
            right++;
        }
    }

    private static void swap(int right, int left, int[] nums) {
        int temp = nums[right];
        nums[right] = nums[left];
        nums[left] = temp;
    }

    public static void main(String[] args) {
        moveZeroes2(new int[]{0, 1, 0, 3, 12});
    }
}
