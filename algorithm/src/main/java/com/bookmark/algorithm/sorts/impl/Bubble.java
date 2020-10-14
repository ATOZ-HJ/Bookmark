package com.bookmark.algorithm.sorts.impl;

import com.bookmark.algorithm.sorts.SortAlgorithm;
import com.bookmark.algorithm.utils.BaseUtil;

import java.util.Arrays;

/**
 * @Author: hj
 * @DateTime: 2020/10/12 9:27
 * @Description: 冒泡排序
 * <p>
 * 1.介绍：冒泡排序（Bubble Sort）也是一种简单直观的排序算法。它重复地走访过要排序的数列，
 * 一次比较两个元素，如果他们的顺序错误就把他们交换过来。走访数列的工作是重复地进行直到没有再需要交换，
 * 也就是说该数列已经排序完成。这个算法的名字由来是因为越小的元素会经由交换慢慢"浮"到数列的顶端。
 * <p>
 * 2.参考连接 ：https://www.runoob.com/w3cnote/bubble-sort.html
 * <p>
 * 3.思路：
 * - 本质为不断查找最大值的过程，第一次查找需要比较次数为 n-1 次
 * - 需要这样的比较  n-1 轮
 */
public class Bubble implements SortAlgorithm {

    @Override
    public int[] sort(int[] arr) {
        //todo 会有冗余比较 ，有序侧会被重复比较
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    //以下两行顺序需要注意
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] arr = BaseUtil.getIntArr();
        Bubble bubble = new Bubble();
        System.out.println(Arrays.toString(bubble.sort(arr)));
    }
}
