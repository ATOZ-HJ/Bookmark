package com.bookmark.exercise;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @Author: hj
 * @DateTime: 2020/9/27 17:08
 * @Description:
 *  给出一堆数，可重复，给定一个固定值，从这几个数中找出任意几个和 为这个固定值的数
 */
public class NumCalculationExe {
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<Integer>() {{
            add(1);
            add(2);
            add(3);
            add(4);
            add(5);
            add(6);
        }};
        Integer key = 10;
        Iterator<Integer> iterator = numbers.iterator();
        List<Integer> resultNums = getResultNums(numbers, key,iterator);
        System.out.println("resultNums = " + resultNums);

    }

    private static List<Integer> getResultNums(List<Integer> numbers, Integer key, Iterator<Integer> iterator) {
        List<Integer> resultNumbers = new ArrayList<>();
        while (iterator.hasNext()) {
            Integer a = iterator.next();
            Integer b = key - a;
            if (numbers.contains(b)) {
                numbers.remove(a);
                resultNumbers.add(b);
            } else {
                getResultNums(numbers,b, iterator);
            }
        }
        return resultNumbers;
    }
}
