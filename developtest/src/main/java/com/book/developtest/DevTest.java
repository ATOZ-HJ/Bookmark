package com.book.developtest;

import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import org.junit.Test;

import java.util.Date;

/**
 * @author: hj
 * @date: 2021-06-10 09:35
 * @description:
 **/

public class DevTest {
    @Test
    public void test1() {
        DateTime now = DateTime.now();
        DateTime beginTime1 = DateUtil.parse("09:00");
        DateTime beginTime = DateUtil.parse("09:01");
        boolean before = now.before(beginTime1);
        System.out.println("before = " + before);
    }
}
