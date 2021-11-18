package com.book.developtest;

import org.apache.commons.lang.StringUtils;

/**
 * @author: hj
 * @date: 2021-11-17 14:48
 * @description:
 **/
public class DevTest {
    public static void main(String[] args) {
        String a = "abc";
        change(a);
        System.out.println("a = " + a);
    }

    private static void change(String a) {
        String replace = a.replace("a", "c");

    }
}
