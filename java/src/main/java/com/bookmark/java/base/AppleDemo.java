package com.bookmark.java.base;

/**
 * @author hj
 * @date 2022-03-22 8:11 上午
 * @description
 */
public class AppleDemo {
    public static void main(String[] args) {
        Apple apple = new Apple();
        apple.setName("a");
        System.out.println("apple1 = " + apple);
        changeName(apple);
        System.out.println("apple3 = " + apple);
    }

    private static void changeName(Apple apple) {
        apple.setName("b");
        System.out.println("apple2 = " + apple);
    }

}
