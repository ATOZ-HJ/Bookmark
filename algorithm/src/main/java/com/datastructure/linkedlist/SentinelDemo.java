package com.datastructure.linkedlist;

/**
 * @author: hj
 * @date: 2021-09-10 10:59
 * @description: 链表课程中的哨兵实现，区别于中间件中的哨兵机制；这里的哨兵是为了处理数据结构或者算法中的边界问题
 *               <p>
 *               demo描述：查找数组中值为key的元素，并返回其下标
 **/

public class SentinelDemo {
    /**
     * 这个方法中没有使用哨兵，所以在for循环中要不断去判断 i 以及if中的逻辑判断，降低了代码的效率
     * 
     * @param arr
     * @param key
     * @return
     */
    public int find1(int[] arr, int key) {
        if (arr == null || arr.length <= 0) {
            return -1;
        }
        int i = 0;
        while (i < arr.length) {
            if (arr[i] == key) {
                return i;
            }
            i++;
        }
        return -1;
    }

    /**
     *
     * @param arr
     * @param key
     * @return
     */
    public int find2(int[] arr, int key) {
        int n = arr.length;
        if (arr == null || n <= 0) {
            return -1;
        }
        // 将key作为 n-1 位的元素，保证数组中至少有一个值和 key 的值相同
        int temp = arr[n - 1];
        arr[n - 1] = key;
        int i = 0;

        while (arr[i] != key) {
            ++i;
        }
        arr[n - 1] = temp;
        if (i == n - 1) {
            return -1;
        } else {
            return i;
        }
    }

}
