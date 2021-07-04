package com.book.developtest;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

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
}
