package com.book.developtest;

import org.junit.Test;

import java.util.Date;

/**
 * @Author: hj
 * @DateTime: 2020/11/3 15:47
 * @Description:
 */
public class TestDateTimeUtil {
    @Test
    public void test1() {
        Date preDate = DateTimeUtil.getDateBeforeNow(3);
        System.out.println("preDate = " + preDate);

        Date beginOfDay = DateTimeUtil.getBeginOfDay(null);
        System.out.println("beginOfDay = " + beginOfDay);
    }
}
