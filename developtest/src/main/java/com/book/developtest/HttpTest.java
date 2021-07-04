package com.book.developtest;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;

/**
 * @author: hj
 * @date: 2021-06-22 14:25
 * @description:
 **/
@RestController
public class HttpTest {
    @PostMapping("/download")
    public File getFile() {
        System.out.println("进入请求");
        File file = new File("C:\\ATOZ\\ksprojects\\docs\\03开发文档\\03客户资料\\交易所\\积存金兑换\\黄金产品发行机构\\i001_20211002_bind_flow.txt");
        return file;
    }
}
