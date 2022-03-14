package com.book.developtest;

/**
 * @author: hj
 * @date: 2022-03-14 14:56
 * @description:
 **/

public class Test2 {
    public static void main(String[] args) {
        int a = 0;
        int b = a;
        if (a > 1 & ++a > 0) {
            b++;
        }
        if (b > 1 && ++b > 0) {
            b--;
        }
        System.out.println("a = " + a);
        System.out.println("b = " + b);
    }

}
