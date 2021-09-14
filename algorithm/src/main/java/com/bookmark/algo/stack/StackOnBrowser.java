package com.bookmark.algo.stack;

/**
 * @author: hj
 * @date: 2021-09-14 19:33
 * @description: 用栈实现浏览器的前进和后退功能
 **/

public class StackOnBrowser {
    private String currentPage;

    private LinkedListBaseStack aheadStack;

    private LinkedListBaseStack backStack;

    /**
     * 前进，从back栈中取出一个作为当前页面，并且将该地址放入到ahead栈中
     * 
     */
    public String ahead() {
        String back = backStack.pop();
        if (back == null) {
            return null;
        }
        this.currentPage = back;
        aheadStack.push(back);
        return currentPage;
    }

    /**
     * 后退，从ahead栈中取出一个作为当前页面，并且将该地址放入到back栈中
     * 
     * @return
     */
    public String back() {
        String ahead = aheadStack.pop();
        if (ahead == null) {
            return null;
        }
        this.currentPage = ahead;
        backStack.push(ahead);
        return currentPage;
    }

    /**
     * 点击新的网页，清空back栈
     * 
     * @param url
     */
    public void click(String url) {

    }

    private static class LinkedListBaseStack {
        private Node top = null;

        public void push(String data) {
            Node newNode = new Node(data, null);
            if (top == null) {
                top = newNode;
            } else {
                newNode.next = top;
                top = newNode;
            }
        }

        public String pop() {
            if (top == null) {
                return null;
            }
            String data = top.data;
            top = top.next;
            return data;
        }
    }

    private static class Node {
        private String data;
        private Node next;

        public Node(String data, Node node) {
            this.data = data;
            this.next = node;
        }

    }
}
