package com.datastructure.sort;

/**
 * @author: hj
 * @date: 2021-08-24 19:36
 * @description: 冒泡排序
 **/
public class BubbleSort {
    /**
     * 冒泡排序
     */
    public static void bubbleSort(int[] arr) {
        //循环多少次
        for (int i = 0; i < arr.length; i++) {
            //每一次循环比较的次数 ,n个数字比较n-1次,
            for (int j = 0; j < arr.length - 1 - i; j++) {

                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }

    }

    public static void main(String[] args) {
        

    }
}
