package com.datastructure.leetcode;

/**
 * @author: hj
 * @date: 2021-01-07 14:49
 * @description: 数组与矩阵
 **/
public class ArraysAndMatrices {

//    private static final int[] arr = {2, 1, 4, 5, 2, 4};

    /**
     * 数组中重复的数字
     * <p>
     * 题目描述:
     * 在一个长度为 n 的数组里的  所有数字都在 0 到 n-1 的范围内 。
     * 数组中某些数字是重复的，但不知道有几个数字是重复的，也不知道每个数字重复几次。
     * 请找出数组中任意一个重复的数字。
     */
    public int[] findDuplication(int[] array) {

        int length = array.length;
        if (length <= 0) {
            return null;
        }
        for (int i : array) {
            int value = array[i];
            if (value != i) {

            }
        }

        return null;
    }

    private void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
