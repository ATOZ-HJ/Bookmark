package com.bookmark.java.jvm;

/**
 * @author hj
 * @date 2022-03-12 8:01 下午
 * @description
 */
public class GcTest {
    public static void main(String[] args) {
        byte[] allocation1, allocation2;
        allocation1 = new byte[53536 * 1024];
        allocation2 = new byte[21536 * 1024];
        System.out.println("方法执行了");

    }
}
