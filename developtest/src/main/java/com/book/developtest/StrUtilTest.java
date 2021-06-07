package com.book.developtest;

import cn.hutool.core.util.StrUtil;
import org.junit.Test;

/**
 * @author: hj
 * @date: 2021-06-04 16:00
 * @description:
 **/

public class StrUtilTest {
    @Test
    public void test1() {
        String str = "123456789123";
        String hide = StrUtil.hide(str, 4, str.length() - 6);
        System.out.println("hide = " + hide);
    }
}
