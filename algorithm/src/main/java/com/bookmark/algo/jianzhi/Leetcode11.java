package com.bookmark.algo.jianzhi;

/**
 * @author: hj
 * @date: 2021-10-23 15:27
 * @description: 盛最多水的容器
 **/

public class Leetcode11 {
    /**
     * 双层for循环，一个一个找，找出所有的组合的最大值,时间复杂度比较高
     *
     * @param height
     * @return
     */
    public static int maxArea(int[] height) {
        int max = 0;
        //注意：以下这种双层for能保证i和j不重复，且不会有反复的组合
        for (int i = 0; i < height.length - 1; i++) {
            for (int j = i + 1; j < height.length; j++) {
                //计算面积，比较最大值
                int area = (j - i) * Math.min(height[i], height[j]);
                max = Math.max(area, max);
            }
        }
        return max;
    }


    /**
     * for循环，用两个指针从数组的两侧进行收敛，找出最大的面积
     * <p>
     * 找出数组中所有的组合的最大值
     *
     * @param height
     * @return
     */
    public static int maxArea2(int[] height) {
        int max = 0;
        int left = 0;
        int right = height.length - 1;
        while (left < right) {
            //计算面积
            int area = (right - left) * Math.min(height[right], height[left]);
            //比较面积
            max = Math.max(area, max);
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return max;
    }

    /**
     * 优化maxArea2中的代码，使其更加优雅
     *
     * @param height
     * @return
     */
    public static int maxArea3(int[] height) {
        int max = 0;
        int left = 0;
        int right = height.length - 1;
        while (left < right) {
            //这里注意三元表达式中 left++ 和right-- 需要在 * 号的后面
            int area = height[right] > height[left] ?
                    (right - left) * height[left++] : (right - left) * height[right--];
            max = Math.max(area, max);
        }
        return max;
    }

    public static void main(String[] args) {
        final int i = maxArea3(new int[]{1, 8});
        System.out.println("i = " + i);
    }
}
