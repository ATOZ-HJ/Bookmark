package com.book.developtest;

/**
 * @Author: hj
 * @DateTime: 2020/10/30 10:24
 * @Description:
 */
public class Test1 {
    public static void main(String[] args) {
//        head = (head - 1) & (elements.length - 1)
        int head = 0;
        int length = 8;
        head = (head - 1) & (length - 1);
        System.out.println("head = " + head);
    }
}
