package com.book.developtest;

import java.util.Set;
import java.util.TreeSet;

/**
 * @author: hj
 * @date: 2021-08-17 13:45
 * @description:
 **/

public class Test {
    @org.junit.Test
    public void test1() {
        Set<String> treeSet = new TreeSet<>((o1, o2) -> o1.compareTo(o2));
        treeSet.add("2006-12-08 15:31:00");
        treeSet.add("2006-12-08 15:31:00");
        treeSet.add("2006-12-07 15:30:00");
        System.out.println("treeSet = " + treeSet);
    }
}
