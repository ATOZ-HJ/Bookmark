package com.bookmark.pdf.docx4j;

import com.bookmark.pdf.util.Docx4JUtil;

import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.Map;

/**
 * main
 * @author brandon
 * @since 2018-08-01
 */
public class Docx4JDemo {

    public static void main(String[] args) throws Exception{

        Map<String, Object> map = new HashMap<>(3);
        map.put("name", "小明");
        map.put("address", "北京市朝阳区");
        map.put("email", "xiaoming@abc.com");
        String ftlName = "resume.ftl";
        String outputFilePath = "D:/documents/demo.pdf";
        FileOutputStream os = new FileOutputStream(outputFilePath);
        Docx4JUtil.process(ftlName, map, os);

    }
}
