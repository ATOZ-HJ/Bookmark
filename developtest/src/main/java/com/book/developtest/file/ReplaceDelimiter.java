package com.book.developtest.file;

import java.io.*;

import org.apache.commons.lang.StringUtils;

/**
 * @author: hj
 * @date: 2021-10-22 16:14
 * @description: 处理文件中的16进制分隔符，将其替换成英文逗号
 **/

public class ReplaceDelimiter {
    public static void main(String[] args) throws IOException {
        long startTime = System.currentTimeMillis();
        System.out.println("开始时间:" + startTime);
        int count = 0;
        // for (int i = 0; i < 64; i++) {
        try (
            // 可能需要将字符集配置在配置文件中
            FileInputStream fis = new FileInputStream(
                "C:\\ATOZ\\myprojects\\Bookmark\\developtest\\src\\main\\resources\\1090_history_source_file.del");
            BufferedReader br = new BufferedReader(new InputStreamReader(fis, "UTF8"));
            BufferedWriter out = new BufferedWriter(new FileWriter(new File(
                "C:\\ATOZ\\myprojects\\Bookmark\\developtest\\src\\main\\resources\\1090_history_source_file_csv.csv"),
                true))) {
            String stx = "\u0002";
            String dc1 = "\u0011";
            String line = br.readLine();
            while (line != null) {
                line = StringUtils.replace(line, stx, ",");
                line = StringUtils.replace(line, dc1, ",");
                System.out.println("line = " + line);
                out.write(line + "\n");
                line = br.readLine();
                count++;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        // }
        long endTime = System.currentTimeMillis();
        System.out.println("结束时间:" + endTime);

        System.out.println("总耗时:" + (endTime - startTime));
        System.out.println("数据行数：" + count);

        // FileInputStream fis =
        // new FileInputStream("C:\\ATOZ\\myprojects\\Bookmark\\developtest\\src\\main\\resources\\1090_sample.csv");
        // InputStreamReader inputStreamReader = new InputStreamReader(fis, "GBK");
        // char[] chars = new char[1024];
        // String content = "";
        // while (inputStreamReader.read(chars) > 0) {
        // content += new String(chars);
        // }
        // // String plainStr =
        // //
        // "\"{2CE400C2-DE1C-4AE2-B91D-409C7DA8E639}\"\u0002\"05中信债2\"\u0002\u0002\"2005-12-09\"\u0002\"\"\u0002\"\"\u0002\"\"\u0002\"1fcazfLASx\"\u0002\"{BFE12234-C629-3436-E030-0003BFE116C7}\"\u0002\"S13257\"\u0002\"\"\u0002\"Q\"\u0002\"银行间债券\"\u0002\"\"\u0002\"058032\"\u0002\"20051226\"\u0002\"20251204\"\u0002\"\u0011\"\u0002\"2018-08-17\"\u0002\"\"\u00020\u0002\u00021\u0002\"\"\u0002\"CNY\"\u0002\"\"\u0002\u0002\u0002\"NIB\"";
        // String stx = "\u0002";
        // String dc1 = "\u0011";
        // content = StringUtils.replace(content, stx, ",");
        // content = StringUtils.remove(content, dc1);
        // System.out.println("content = " + content);
    }
}
