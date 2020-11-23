package com.book.jdk.java8.lambda;

import org.checkerframework.checker.units.qual.A;
import org.junit.Test;
import org.springframework.util.CollectionUtils;

import java.util.*;
import java.util.concurrent.TimeUnit;

/**
 * @Author: hj
 * @DateTime: 2020/10/30 13:28
 * @Description:
 */

public class AllTest {

    @Test
    public void test1() {

        Formula formula = new Formula() {
            @Override
            public double calculate(int a) {
                return sqrt(100 * a);
            }
        };
        System.out.println(formula.sqrt(16));
        System.out.println(formula.calculate(100));
    }

    @Test
    public void test2() {
        List<String> list = Arrays.asList("a", "b", "c", "d", "e", "f");
        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o2.compareTo(o1);
            }
        });
        System.out.println("list1 = " + list);

        Collections.sort(list, (String a, String b) -> b.compareTo(a));
        System.out.println("list2 = " + list);

        Collections.sort(list, Comparator.reverseOrder());
        System.out.println("list3 = " + list);
    }

    @Test
    public void test3() {
        PersonFactory<Person> personFactory = Person::new;
    }


    @Test
    public void test4() {
        List<String> stringCollection = new ArrayList<>();
        stringCollection.add("ddd2");
        stringCollection.add("aaa2");
        stringCollection.add("bbb1");
        stringCollection.add("aaa1");
        stringCollection.add("bbb3");
        stringCollection.add("ccc");
        stringCollection.add("bbb2");
        stringCollection.add("ddd1");
        System.out.println("stringCollection = " + stringCollection);
//        stringCollection.stream().sorted().forEach(System.out::println);
//        boolean anyMatch = stringCollection.stream().anyMatch(a -> a.startsWith("a"));
//        System.out.println("anyMatch = " + anyMatch);
        Optional<String> reduce = stringCollection.stream().sorted().reduce((a, b) -> a + "#" + b);
        reduce.ifPresent(System.out::println);

    }

    @Test
    public void orderStreamTest() {
       //创建一个集合 包含100 0000 个随机数
        int max = 1000000;
        List<String> values = new ArrayList<>();
        for (int i = 0; i < max; i++) {
            UUID uuid = UUID.randomUUID();
            values.add(uuid.toString());
        }
        //获取当前时间
        long start = System.currentTimeMillis();
        long count = values.stream().sorted().count();
        System.out.println("count = " + count);
        long end = System.currentTimeMillis();

        long interval = end - start;
        // 64
        System.out.println("interval = " + interval);

    }

    @Test
    public void parallelStreamTest() {
        //创建一个集合 包含100 0000 个随机数
        int max = 1000000;
        List<String> values = new ArrayList<>();
        for (int i = 0; i < max; i++) {
            UUID uuid = UUID.randomUUID();
            values.add(uuid.toString());
        }
        //获取当前时间
        long start = System.currentTimeMillis();
        long count = values.parallelStream().sorted().count();
        System.out.println("count = " + count);
        long end = System.currentTimeMillis();

        long interval = end - start;
        System.out.println("interval = " + interval);
    }



}
