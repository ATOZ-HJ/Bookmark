package com.book;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author: hj
 * @date: 2022-03-14 20:01
 * @description:
 **/

public class Test2 {
//    public String arrangeWords(String str) {
//        //1. 分割字符
//        final String[] words = str.split(" ");
//        for (int i = 0; i < words.length; i++) {
//            System.out.println(words[i]);
//        }
//        for (int i = 0; i < words.length; i++) {
//            int k = i;
//            for (int j = i + 1; j < words.length; j++) {
//                if (words[k].compareTo(words[j]) > 0) {
//                    k = j;
//                }
//            }
//            if (k != i) {
//            }
//        }
//    }

    public static void main(String[] args) {
        //手动输入字符串
        Scanner in = new Scanner(System.in);
        final String phase = in.nextLine();

//        String str = "5 1 3 2 6 9 8 7 10 4";
        final String[] arr = phase.split(" ");
        Arrays.sort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}
