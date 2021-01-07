package com.book.developtest;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author: hj
 * @date: 2021-01-05 15:33
 * @description:
 **/
public class HttpUtilTest {
    public static void main(String[] args) {
        HttpUtil instance = HttpUtil.getInstance();
        HttpUtil httpClient = HttpUtil.getInstance();
        String url = "http://10.253.48.56:10088/cmds/v1/gold/minute";
        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMDD000000");
        String format = dateFormat.format(date);
        System.out.println("format = " + format);

    }
}
