package com.book.developtest.io;

import java.lang.reflect.Field;

/**
 * @author: hj
 * @date: 2021-07-20 15:25
 * @description:
 **/

public class ReflectTest {
    public static void main(String[] args) throws IllegalAccessException {
        Class<Apple> appleClass = Apple.class;
        Apple apple = new Apple();
        Field[] declaredFields = appleClass.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            declaredField.setAccessible(true);
            declaredField.set(apple, "苹果");
            declaredField.setAccessible(false);
            String name = declaredField.getName();
            System.out.println("name = " + name);
        }
        System.out.println(apple);
    }
}
