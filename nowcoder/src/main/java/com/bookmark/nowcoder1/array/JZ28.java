package com.bookmark.nowcoder1.array;

import org.junit.Test;

import java.util.HashMap;

/**
 * @author: hj
 * @date: 2021-06-15 08:51
 * @description: 数组中有一个数字出现的次数超过数组长度的一半，
 * 请找出这个数字。例如输入一个长度为9的数组[1,2,3,2,2,2,5,4,2]。
 * 由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。你可以假设数组是非空的，
 * 并且给定的数组总是存在多数元素。1<=数组长度<=50000
 * <p>
 * https://www.nowcoder.com/practice/e8a1b01a2df14cb2b228b30ee6a92163
 **/

public class JZ28 {
    /**
     * 方法一 ，使用map来保存数组中每个元素的count
     * 这个方法牛客网编译不通过，不允许使用hashmap
     *
     * @param array
     * @return
     */
    public int MoreThanHalfNum_Solution(int[] array) {
        int lengthHalf = array.length / 2;
        HashMap<Integer, Integer> map = new HashMap<>(16);
        for (int a : array) {
            if (!map.containsKey(a)) {
                map.put(a, 1);
            } else {
                Integer count = map.get(a);
                map.put(a, ++count);
                if (count > lengthHalf) {
                    return a;
                }
            }
        }
        return 0;
    }

    /**
     * 排序法：1. 先将数组排序；2. 找出位于数组下标中值的元素
     * <p>
     * 运行时间：350ms
     * 超过0.25% 用Java提交的代码
     * 占用内存：16548KB
     * 超过9.96%用Java提交的代码
     * <p>
     * 双层for排序，效率低
     *
     * @param array
     * @return
     */
    public int MoreThanHalfNum_Solution2(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = i + 1; j < array.length; j++) {
                int temp = 0;
                if (array[i] > array[j]) {
                    temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }
        return array[array.length / 2];
    }


    /**
     * 候选法 官方建议题解
     * 1. 遍历数组，使用preValue记录当前的值
     * 2. 用count记录当前值出现的次数
     * 3. 如果下一个值和preValue相等，count++，否则 count--
     * 4. 当count==0，preValue = 当前值
     * 5. 如果一个数出现的次数超过当前数组长度的一半,则遍历完成后，preValue一定是该值，并且count>0
     *
     * @param array
     * @return
     */
    public int MoreThanHalfNum_Solution3(int[] array) {
        if (array == null || array.length == 0) {
            return 0;
        }
        int count = 1;
        int preValue = array[0];
        for (int i = 1; i < array.length; i++) {
            if (preValue == array[i]) {
                count++;
            } else {
                count--;
                if (count == 0) {
                    preValue = array[i];
                }
            }
        }
        //如果在数组中存在超过一半的数组长度的值，则preValue一定是该值，接下来还需要验证这个值在数组中出现的次数的确超过数组长度一般
        int num = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == preValue) {
                num++;
            }
        }
        return num > array.length / 2 ? preValue : 0;
    }

    @Test
    public void test1() {
        int result1 = MoreThanHalfNum_Solution(new int[]{
                1, 2, 3, 2, 2, 2, 5, 4, 2
        });
        System.out.println("result1 = " + result1);
    }
}
