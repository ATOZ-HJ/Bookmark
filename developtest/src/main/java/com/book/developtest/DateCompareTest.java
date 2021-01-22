package com.book.developtest;

import java.util.Date;

/**
 * @author: hj
 * @date: 2021-01-19 16:42
 * @description:
 **/
public class DateCompareTest {
    public static void main(String[] args) {
        Date startDate = new Date(1610298061000L);
        Date endDate = new Date();
        if (endDate.before(startDate)) {
            System.out.println("yes = " + "yes");
        } else {
            System.out.println("no");
        }
    }
}
