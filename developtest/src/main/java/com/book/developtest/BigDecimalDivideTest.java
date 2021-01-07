package com.book.developtest;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * @author: hj
 * @date: 2020-12-31 09:41
 * @description:
 **/
public class BigDecimalDivideTest {
    public static void main(String[] args) {
        BigDecimal a = new BigDecimal("1");
        BigDecimal b = new BigDecimal("3");
        BigDecimal c = new BigDecimal("8");
        BigDecimal divide =c.multiply(a.divide(b)).setScale(2,BigDecimal.ROUND_HALF_UP) ;
        System.out.println("divide = " + divide);
    }
}
