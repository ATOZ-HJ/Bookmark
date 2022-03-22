package com.bookmark.java.map;

import java.util.LinkedHashMap;

/**
 * @author hj
 * @date 2022-03-19 8:56 上午
 * @description
 */
public class LinkedHashMapDemo {
    public static void main(String[] args) {
        LinkedHashMap<String, String> map = new LinkedHashMap<String, String>(8, 0.8f, true);
        map.put("a", "a");
        map.put("b", "b");
        map.put("a", "c");
        System.out.println("map = " + map);
    }
}
