package com.bookmark.algorithm.utils;

/**
 * @Author: hj
 * @DateTime: 2020/10/12 11:00
 * @Description: 基础工具类
 */
public class BaseUtil {

    /**
     * 获取基础的乱序数组
     *
     * @return
     */
    public static int[] getIntArr() {
        return new int[]{
                34, 15, 78, 24, 9, 36, 17};
    }

    /**
     * 校验数组是否为空数组，或者 为null
     *
     * @param arr
     * @return
     */
    public static boolean isEmpty(int[] arr) {
        return arr == null || arr.length == 0;
    }
}
