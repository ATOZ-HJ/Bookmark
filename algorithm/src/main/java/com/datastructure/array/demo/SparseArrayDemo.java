package com.datastructure.array.demo;

import java.util.Arrays;
import java.util.Objects;

/**
 * @author: hj
 * @date: 2021-02-22 16:17
 * @description: 稀疏数组demo实现
 * 涉及二维数组概念
 **/
public class SparseArrayDemo {
    public static void main(String[] args) {
        //初始化原始的二维数组 [行][列]
        int[][] arr1 = new int[11][12];
        //第一行的第三列 设置值为 2
        //第三行的第五列 设置值为 1
        //第四行的第一列 设置值为 2
        arr1[0][2] = 2;
        arr1[2][4] = 1;
        arr1[3][0] = 2;
        int[] rowOne = arr1[0];
        String rowOneStr = Arrays.toString(rowOne);
        System.out.println("rowOne = " + rowOneStr);
        //打印原始数组
        System.out.println("打印原始的二维数组:");
        print(arr1);
        //稀疏数组的长度=数组的行数
        System.out.println("打印原始数组长度:" + arr1.length);
        System.out.println("--------------分割线---------------");
        //将原始二维数组转换为稀疏数组
        int[][] sparseArr = toSparseArr(arr1);
        System.out.println("打印稀疏数组");
        print(sparseArr);

        //稀疏数组转成原始数组
        int[][] arr2 = to2dArray(sparseArr);
        System.out.println("稀疏数组转成二维数组:");
        print(arr2);
    }

    public static void print(int[][] arr) {
        for (int[] ints : arr) {
            for (int v : ints) {
                System.out.print(v + " ");
            }
            System.out.println();
        }
    }

    /**
     * 二维数组转稀疏数组
     *
     * @param arr 原始的二维数组
     * @return
     */
    public static int[][] toSparseArr(int[][] arr) {
        if (Objects.isNull(arr)) {
            throw new NullPointerException("original array is null");
        }
        int row = arr.length;
        int col = arr[0].length;
        return toSparseArr(arr, row, col);
    }

    /**
     * 二维数组转稀疏数组
     *
     * @param arr 原始数组
     * @param row 行
     * @param col 列
     * @return
     */
    public static int[][] toSparseArr(int[][] arr, int row, int col) {
        //原始数组的有效值个数
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            //最好加入一个判断每行内含有的元素个数是否相同的校验
            int rowNum = arr[i].length;
            if (rowNum != col) {
                throw new RuntimeException("传入的数组格式有误,数组应为一个 m * n 的二维数组");
            }
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] != 0) {
                    count++;
                }
            }
        }
        int[][] sparseArr = new int[count + 1][3];
        sparseArr[0][0] = row;
        sparseArr[0][1] = col;
        sparseArr[0][2] = count;
        //将有效值填入到稀疏数组中
        int countRow = 1;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] != 0) {
                    sparseArr[countRow][0] = i;
                    sparseArr[countRow][1] = j;
                    sparseArr[countRow][2] = arr[i][j];
                    countRow++;
                }
            }
        }
        return sparseArr;
    }


    /**
     * 稀疏数组转二维数组
     *
     * @param sparseArr 稀疏数组
     * @return
     */
    public static int[][] to2dArray(int[][] sparseArr) {
        if (Objects.isNull(sparseArr)) {
            throw new NullPointerException("sparseArray is null");
        }
        int row = sparseArr[0][0];
        int col = sparseArr[0][1];
        int[][] arr = new int[row][col];
        for (int i = 1; i < sparseArr.length; i++) {
            arr[sparseArr[i][0]][sparseArr[i][1]] = sparseArr[i][2];
        }
        return arr;
    }

}
