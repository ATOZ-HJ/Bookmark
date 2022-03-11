package com.bookmark.java.base;

/**
 * @author: hj
 * @date: 2022-03-11 17:05
 * @description: 自增实现底层探究
 **/

public class SelfIncreaseTest {
    public static void main(String[] args) {
        int i = 1;
        i = i++;
        //1 因为 i++ 底层实现如下，是返回临时变量
        //temp=i
        //i=i+1
        //return temp
        System.out.println("i = " + i);
    }
}
