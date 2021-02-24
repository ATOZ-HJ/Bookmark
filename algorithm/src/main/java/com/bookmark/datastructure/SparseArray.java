package com.bookmark.datastructure;

import java.util.Arrays;

/**
 * @author: hj
 * @date: 2021-02-22 16:17
 * @description: 稀疏数组demo实现
 * 涉及二维数组概念
 **/
public class SparseArray {
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
        System.out.println("打印原始数组长度:"+arr1.length);
        System.out.println("--------------分割线---------------");
        //将原始二维数组转换为稀疏数组 ，只保存有效值
        //1.需要确定稀疏数组的行数，也就是有几个有效值
        int count = 0;
        for (int[] ints : arr1) {
            for (int v : ints) {
                if (v != 0) {
                    count++;
                }
            }
        }
        System.out.println("稀疏数组的有效值个数为:" + count);
        //2.创建稀疏数组
        int[][] sparseArr = new int[count+1][3];
        //3.第一行数据为原始二维数组的行、列、有效值个数
        sparseArr[0][0] = 11;
        sparseArr[0][1] = 11;
        sparseArr[0][2] = count;
        //4.除第一行外，其他行的数据为有效值的坐标以及value
        int count2 = 1;
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j <11; j++) {
                if (arr1[i][j] != 0) {
                    sparseArr[count2][0] = i;
                    sparseArr[count2][1] = j;
                    sparseArr[count2][2] = arr1[i][j];
                    count2++;
                }
            }
        }
        System.out.println("打印稀疏数组");
        print(sparseArr);


        //稀疏数组转成原始数组
        //取出稀疏数组第一行的数据
        //原始数组 行
        int rowNum = sparseArr[0][0];
        //原始数组 列
        int colNum = sparseArr[0][1];

        int[][] arr2 = new int[rowNum][colNum];
        for (int i =1; i < sparseArr.length; i++) {
            int row = sparseArr[i][0];
            int col = sparseArr[i][1];
            int value = sparseArr[i][2];
            arr2[row][col] = value;
        }
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

    public static int[][] toSparseArr(int[][] arr) {
        return null;
    }

}
