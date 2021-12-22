 package com.bookmark.algo.array;

/**
 * @author: hj
 * @date: 2021-12-16 19:04
 * @description: remove-duplicates-from-sorted-array
 * <p>
 * 给你一个有序数组 nums ，请你 原地 删除重复出现的元素，使每个元素 只出现一次 ，返回删除后数组的新长度。
 * <p>
 * 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
 * <p>
 *  
 * <p>
 * 说明:
 * <p>
 * 为什么返回数值是整数，但输出的答案是数组呢?
 * <p>
 * 请注意，输入数组是以「引用」方式传递的，这意味着在函数里修改输入数组对于调用者是可见的。
 * <p>
 * 你可以想象内部操作如下:
 * <p>
 * // nums 是以“引用”方式传递的。也就是说，不对实参做任何拷贝
 * int len = removeDuplicates(nums);
 * <p>
 * // 在函数里修改输入数组对于调用者是可见的。
 * // 根据你的函数返回的长度, 它会打印出数组中 该长度范围内 的所有元素。
 * for (int i = 0; i < len; i++) {
 *     print(nums[i]);
 * }
 *  
 * 示例 1：
 * <p>
 * 输入：nums = [1,1,2]
 * 输出：2, nums = [1,2]
 * 解释：函数应该返回新的长度 2 ，并且原数组 nums 的前两个元素被修改为 1, 2 。不需要考虑数组中超出新长度后面的元素。
 * 示例 2：
 * <p>
 * 输入：nums = [0,0,1,1,1,2,2,3,3,4]
 * 输出：5, nums = [0,1,2,3,4]
 * 解释：函数应该返回新的长度 5 ， 并且原数组 nums 的前五个元素被修改为 0, 1, 2, 3, 4 。不需要考虑数组中超出新长度后面的元素。
 *  
 * <p>
 * 提示：
 * <p>
 * 0 <= nums.length <= 3 * 104
 * -104 <= nums[i] <= 104
 * nums 已按升序排列
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * </p>
 **/
public class Leetcode26 {
    /**
     * 如果有重复的值，则这两个值相邻
     *
     * @param nums
     * @return
     */
    public static int removeDuplicates(int[] nums) {
        //数组长度为0，则直接返回0

        //数据长度>0 ,数组中的第一个元素肯定是会返回的
        //所以可以从下标1开始进行遍历
        //数组有序，所有如果有重复的元素，那么重复的元素下标是相连的
        //利用快慢指针fast 和 slow，fast表示数组指针的位置，slow表示
        //数组长度为0，则直接返回0
        if (nums.length == 0) {
            return 0;
        }
        int slow = 1;
        for (int fast = 1; fast < nums.length; fast++) {
            if (nums[fast] == nums[fast -1]) {
                continue;
            } else {
                //交换快慢指针处的元素
                swap(nums, slow, fast);
                slow++;
            }
        }
        return slow ;
    }
    private  static void swap(int[] nums, int slow, int fast) {
        nums[slow] = nums[fast];
    }

    public static void main(String[] args) {
        final int i = removeDuplicates(new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4});
        System.out.println("i = " + i);
    }
}
