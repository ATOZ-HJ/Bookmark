package com.book.jdk.java8.lambda;

/**
 * @Author: hj
 * @DateTime: 2020/10/30 13:21
 * @Description:
 */
@FunctionalInterface
public interface Formula {
    /**
     * 抽象方法，可以有多个
     *
     * @param a
     * @return
     */
    double calculate(int a);

    /**
     * 默认方法，可以有多个
     *
     * @param a
     * @return
     */
    default double sqrt(int a) {
        return Math.sqrt(a);
    }

}
