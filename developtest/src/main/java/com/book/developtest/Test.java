package com.book.developtest;

/**
 * @author: hj
 * @date: 2021-08-17 13:45
 * @description:
 **/

public class Test {
    public static void main(String[] args) {
        StringBuffer a = new StringBuffer("a");
        StringBuffer b = new StringBuffer("b");

        operate(a, b);

        System.out.println(a + "," + b);
    }

    static void operate(StringBuffer a, StringBuffer b) {

        b = b.append(a);
        b = a;
    }
}
