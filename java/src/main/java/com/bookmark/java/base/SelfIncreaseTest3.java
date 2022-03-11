package com.bookmark.java.base;

/**
 * @author: hj
 * @date: 2022-03-11 17:05
 * @description: 自增实现底层探究
 **/

public class SelfIncreaseTest3 {
    public static int sum() {
        int i = 1;
        try {
            return i++;
        }finally {
            i++;
        }
    }
    public static void main(String[] args) {
        int sum = sum();
        System.out.println("sum = " + sum);
    }
}
