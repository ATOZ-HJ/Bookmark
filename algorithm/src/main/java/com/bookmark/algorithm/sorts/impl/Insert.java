package com.bookmark.algorithm.sorts.impl;

import com.bookmark.algorithm.sorts.SortAlgorithm;
import com.bookmark.algorithm.utils.BaseUtil;

import java.util.Arrays;

/**
 * @Author: hj
 * @DateTime: 2020/10/12 9:28
 * @Description: 插入排序
 * 介绍：插入排序的代码实现虽然没有冒泡排序和选择排序那么简单粗暴，但它的原理应该是最容易理解的了，
 * 因为只要打过扑克牌的人都应该能够秒懂。插入排序是一种最简单直观的排序算法，它的工作原理是通过构建有序序列，
 * 对于未排序数据，在已排序序列中从后向前扫描，找到相应位置并插入。
 * 插入排序和冒泡排序一样，也有一种优化算法，叫做拆半插入。
 * <p>
 * 思路：
 * arr[0] > arr[1]
 * int temp = arr [0]
 * arr[1] = temp
 * arr[0] = arr[1]
 */
public class Insert implements SortAlgorithm {
    @Override
    public int[] sort(int[] arr) {
        //TODO 以下实现是否正确
        for (int i = 0; i < arr.length; i++) {
            int temp = arr[i];
            for (int j = i; j > 0; j--) {
                if (temp < arr[j - 1]) {
                    arr[j] = arr[j - 1];
                    arr[j - 1] = temp;
                } else {
                    //停止内层的当前循环
                    break;
                }
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        Insert insert = new Insert();
        int[] intArr = BaseUtil.getIntArr();
        int[] sort = insert.sort(intArr);
        System.out.println(Arrays.toString(sort));

    }
}
