package com.bookmark.algo.nowcoder.array;

import java.util.HashSet;

/**
 * @author: hj
 * @date: 2021-08-17 20:07
 * @description: 数组中重复的数字
 *               <p>
 *               描述：在一个长度为n的数组里的所有数字都在0到n-1的范围内。 数组中某些数字是重复的，但不知道有几个数字是重复的。也不知道每个数字重复几次。 请找出数组中任一一个重复的数字。
 *               例如，如果输入长度为7的数组[2,3,1,0,2,5,3]， 那么对应的输出是2或者3。存在不合法的输入的话输出-1
 *               <p>
 *               示例1： 输入： [2,3,1,0,2,5,3] 返回值： 2 说明： 2或3都是对的
 *               <p>
 *               https://www.nowcoder.com/practice/6fe361ede7e54db1b84adc81d09d8524
 **/
public class JZ50 {
    /**
     * 使用set保存数值
     * <p>
     * 运行时间：77ms 超过18.25% 用Java提交的代码 占用内存：15408KB 超过1.02%用Java提交的代码
     * <p>
     * 时间复杂度: n 空间复杂度: n
     *
     * @param numbers
     *            int整型一维数组
     * @return int整型
     */
    public int duplicate1(int[] numbers) {
        if (numbers.length == 0) {
            return -1;
        }
        HashSet<Integer> set = new HashSet<>(16);
        for (int number : numbers) {
            if (set.contains(number)) {
                return number;
            } else {
                set.add(number);
            }
        }
        return -1;
    }

    /**
     * 双层for循环 运行时间：79ms 超过14.57% 用Java提交的代码 占用内存：14384KB 超过28.72%用Java提交的代码
     * <p>
     * 时间复杂度n^2
     *
     * @param numbers
     * @return
     */
    public int duplicate2(int[] numbers) {
        // 采用双层for循环，判断是否有重复的
        if (numbers.length == 0) {
            return -1;
        }
        for (int i = 0; i < numbers.length; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                if (numbers[i] == numbers[j]) {
                    return numbers[i];
                }
            }
        }
        return -1;
    }

    /**
     * 可以先排序，然后遍历，如果相邻两个元素相等，则返回
     * <p>
     * 运行时间：108ms 超过2.64% 用Java提交的代码 占用内存：13952KB 超过32.13%用Java提交的代码
     * <p>
     *
     * @param numbers
     * @return
     */
    public int duplicate3(int[] numbers) {
        if (numbers.length == 0) {
            return -1;
        }
        // 先排序(针对排序算法，接下来会专门训练)
        // todo 优化排序算法，使用更好的实现
        for (int i = 0; i < numbers.length - 1; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                int temp = 0;
                if (numbers[i] > numbers[j]) {
                    temp = numbers[i];
                    numbers[i] = numbers[j];
                    numbers[j] = temp;
                }
            }
        }

        // 循环数组，判断相邻的两个元素是否有重复的元素
        for (int i = 0; i < numbers.length - 1; i++) {
            if (numbers[i] == numbers[i + 1]) {
                return numbers[i];
            }
        }
        return -1;
    }

    /**
     * 由题意 在一个长度为n的数组里的所有数字都在0到n-1的范围内 将数组中的各元素放到与元素值相对应的下标上，如果该下标的值与该元素的值相等，则有重复值
     * <p>
     * 运行时间：62ms 超过49.10% 用Java提交的代码 占用内存：14244KB 超过30.32%用Java提交的代码
     *
     * @param numbers
     * @return
     */
    public static int duplicate4(int[] numbers) {
        if (numbers.length == 0) {
            return -1;
        }
        for (int i = 0; i < numbers.length; i++) {
            if (i == numbers[i]) {
                continue;
            }
            if (numbers[i] == numbers[numbers[i]]) {
                return numbers[i];
            } else {
                int temp = numbers[numbers[i]];
                numbers[numbers[i]] = numbers[i];
                numbers[i] = temp;
                i--;//
            }
        }
        return -1;
    }

    /**
     * 1.开启一个新的数组来记录原数组中元素出现的次数 2.原数组值对应的新数组下标
     * <p>
     * 运行时间：60ms 超过54.44% 用Java提交的代码 占用内存：14068KB 超过31.53%用Java提交的代码
     * <p>
     *
     * @param numbers
     * @return
     */
    public static int duplicate5(int[] numbers) {
        int[] count = new int[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            if (count[numbers[i]] > 0) {
                return numbers[i];
            } else {
                count[numbers[i]]++;
            }
        }
        return -1;
    }

    private static void swap(int[] numbers, int i) {
        int temp;
        temp = numbers[i];
        numbers[i] = numbers[numbers[i]];
        numbers[temp] = temp;
    }

    public static void main(String[] args) {
        int i = duplicate5(new int[] {2, 3, 1, 0, 2, 5, 3});
        System.out.println("i = " + i);

    }
}
