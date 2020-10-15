package com.bookmark.algorithm.sorts;

/**
 * @Author: hj
 * @DateTime: 2020/10/12 11:05
 * @Description:
 *
 * todo； 冒泡，插入，选择排序算法需要检查优化
 *
 * 注意： 1. 需要比较多少轮
 *       2.  每轮需要比较多少次
 */
public interface SortAlgorithm {
    /**
     * 排序
     *
     * @param arr
     * @return
     */
    int[] sort(int[] arr);
}
