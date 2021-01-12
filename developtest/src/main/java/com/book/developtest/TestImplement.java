package com.book.developtest;

/**
 * @author: hj
 * @date: 2021-01-12 16:25
 * @description:
 **/
public class TestImplement implements User,Consumer {
    @Override
    public void speak(String name) {
        System.out.println("name = " + name);
    }

    public static void main(String[] args) {
        Consumer consumer
                = new TestImplement();
        consumer.speak("猪头");

    }
}
