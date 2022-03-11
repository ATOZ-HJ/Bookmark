package com.bookmark.java.base;

/**
 * @author: hj
 * @date: 2022-03-11 17:05
 * @description: 自增实现底层探究
 **/

public class SelfIncreaseTest2 {
    public static void main(String[] args) {
        int i = 1;
        int sum = (i++) + (i++);
        System.out.println("sum = " + sum);
    }
}
