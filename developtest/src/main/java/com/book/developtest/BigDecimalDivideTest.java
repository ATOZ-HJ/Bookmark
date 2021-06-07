package com.book.developtest;

import org.junit.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * @author: hj
 * @date: 2020-12-31 09:41
 * @description:
 **/
public class BigDecimalDivideTest {
    @Test
    public void testMulti() {
        BigDecimal dec10 = new BigDecimal("10");
        BigDecimal dec3 = new BigDecimal("3");
        BigDecimal dec20 = new BigDecimal("20");
        BigDecimal dec7 = new BigDecimal("7");
        BigDecimal subtract = dec10.subtract(dec3).multiply(dec20).subtract(dec7);
        System.out.println("subtract = " + subtract);
    }
}
