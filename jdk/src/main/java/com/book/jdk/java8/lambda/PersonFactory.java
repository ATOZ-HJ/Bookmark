package com.book.jdk.java8.lambda;

/**
 * @Author: hj
 * @DateTime: 2020/11/14 17:27
 * @Description:
 */
public interface PersonFactory<P extends Person> {
    P create(String firstName, String lastName);
}
