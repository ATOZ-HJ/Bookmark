package com.book.developtest.io;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.io.IoUtil;
import cn.hutool.core.util.StrUtil;

import java.io.BufferedInputStream;
import java.io.File;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author: hj
 * @date: 2021-07-20 14:43
 * @description:
 **/

public class FileParse {
    public static void main(String[] args) {
        BufferedInputStream inputStream = FileUtil.getInputStream(new File("C:\\ATOZ\\myprojects\\Bookmark\\developtest\\src\\main\\resources\\i001_20211002_exch_flow.txt"));
        ArrayList<String> strings = IoUtil.readLines(inputStream, Charset.defaultCharset(), new ArrayList<String>());
        strings.forEach(item -> {
            System.out.println("item = " + item);
            String[] array = StrUtil.split(item, "\u0001");
            String str = Arrays.toString(array);
            System.out.println("str = " + str);
        });
        IoUtil.close(inputStream);
    }
}
