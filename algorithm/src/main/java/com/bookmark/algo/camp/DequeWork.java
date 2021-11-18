package com.bookmark.algo.camp;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author hj
 * @date 2021-11-18 9:27 下午
 * @description
 */
public class DequeWork {
    public static void main(String[] args) {
        Deque<String> deque = new LinkedList<>();
        deque.addFirst("a");
        deque.addFirst("b");
        deque.addLast("c");
        System.out.println("deque = " + deque);
    }
}
