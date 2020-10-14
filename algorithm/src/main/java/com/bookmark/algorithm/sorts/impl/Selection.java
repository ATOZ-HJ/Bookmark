package com.bookmark.algorithm.sorts.impl;

import com.bookmark.algorithm.sorts.SortAlgorithm;
import com.bookmark.algorithm.utils.BaseUtil;

import java.util.Arrays;

/**
 * @Author: hj
 * @DateTime: 2020/10/12 9:26
 * @Description: 选择排序
 * 介绍：
 * 1. 首先在未排序序列中找到最小（大）元素，存放到排序序列的起始位置。
 * 2. 再从剩余未排序元素中继续寻找最小（大）元素，然后放到已排序序列的末尾。
 * 3. 重复第二步，直到所有元素均排序完毕。
 * <p>
 * 链接： https://www.runoob.com/w3cnote/selection-sort.html
 * <p>
 * 思路：1.第一次循环整个数组，查找到最小值，然后放到数组的第一个位置；
 */
public class Selection implements SortAlgorithm {

    @Override
    public int[] sort(int[] arr) {

        for (int i = 0; i < arr.length; i++) {
            int min = arr[i];
            int flag = i;
            for (int j = i; j < arr.length; j++) {
                if (arr[j] < min) {
                    min = arr[j];
                    flag = j;
                }
            }
            arr[flag] = arr[i];
            arr[i] = min;
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] intArr = BaseUtil.getIntArr();
        Selection selection = new Selection();
        int[] sort = selection.sort(intArr);
        System.out.println(Arrays.toString(sort));

    }
}
