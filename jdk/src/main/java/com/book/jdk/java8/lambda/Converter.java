package com.book.jdk.java8.lambda;

/**
 * @Author: hj
 * @DateTime: 2020/10/30 15:52
 * @Description:
 */
public interface Converter<F, T> {
    T convert(F from);
}
