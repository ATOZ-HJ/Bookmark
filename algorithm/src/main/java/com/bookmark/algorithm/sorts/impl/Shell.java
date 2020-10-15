package com.bookmark.algorithm.sorts.impl;

import com.bookmark.algorithm.sorts.SortAlgorithm;
import com.bookmark.algorithm.utils.BaseUtil;

import java.util.Arrays;

/**
 * @Author: hj
 * @DateTime: 2020/10/14 15:42
 * @Description: 希尔排序
 * <p>
 * 1. 介绍
 * 希尔排序，也称递减增量排序算法，是插入排序的一种更高效的改进版本。但希尔排序是非稳定排序算法。
 * 希尔排序是基于插入排序的以下两点性质而提出改进方法的：
 * 插入排序在对几乎已经排好序的数据操作时，效率高，即可以达到线性排序的效率；
 * 但插入排序一般来说是低效的，因为插入排序每次只能将数据移动一位；
 * 希尔排序的基本思想是：先将整个待排序的记录序列分割成为若干子序列分别进行直接插入排序，
 * 待整个序列中的记录"基本有序"时，再对全体记录进行依次直接插入排序。
 *
 * 2.思路：获取数组长度，二分获取第一次间隔，
 *         获取到间隔后，
 */
public class Shell implements SortAlgorithm {
    @Override
    public int[] sort(int[] arr) {
        // todo 不会写

        return arr;
    }

    public static void main(String[] args) {
        int[] intArr = BaseUtil.getIntArr();
        System.out.println("intArr = " + Arrays.toString(intArr));
        Shell shell = new Shell();
        int[] sort = shell.sort(intArr);
        System.out.println("sort = " + Arrays.toString(sort));
    }
}
