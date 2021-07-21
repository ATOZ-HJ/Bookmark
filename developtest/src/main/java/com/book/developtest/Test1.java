package com.book.developtest;

import cn.hutool.core.util.HashUtil;
import cn.hutool.crypto.SecureUtil;
import org.junit.Test;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.*;

/**
 * @Author: hj
 * @DateTime: 2020/10/30 10:24
 * @Description:
 */
public class Test1 {

    @Test
    public void test1() {
        List<String> aList = new ArrayList<>();
        List<String> bList = new ArrayList<>();
        aList.add("1");
        aList.add("2");
        aList.add("3");
        aList.add("4");

        bList.add("2");
        bList.add("3");
        bList.add("4");
        bList.add("5");

//        aList.retainAll(bList);
//        System.out.println("aList = " + aList);

        aList.removeAll(bList);

        aList.addAll(bList);

        System.out.println("aListall = " + aList);

        HashMap<String, String> aMap = new HashMap<>();
        aMap.put("1", "1");
        String aMapValue = aMap.get("2");
        System.out.println("aMapValue = " + aMapValue);
    }

    @Test
    public void test2() throws NoSuchAlgorithmException {
        String text = "abc";
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        byte[] hash1 = digest.digest(text.getBytes(StandardCharsets.UTF_8));
        System.out.println("hash1 = " + hash1);

        int hash2 = HashUtil.rsHash(text);
        System.out.println("hash2 = " + hash2);

        String hash3 = SecureUtil.sha256(text);
        System.out.println("hash3 = " + hash3);

    }

    @Test
    public void treeMapTest() {
        SortedMap<String, String> parameters = new TreeMap<String, String>();
        parameters.put("GBP-Timestamp", "789");
        parameters.put("GBP-SYS-ID", "456");
        parameters.put("A", "123");
        Set<Map.Entry<String, String>> entries = parameters.entrySet();
        for (Map.Entry<String, String> entry : entries) {
            System.out.println("entry = " + entry);
        }
    }
}
