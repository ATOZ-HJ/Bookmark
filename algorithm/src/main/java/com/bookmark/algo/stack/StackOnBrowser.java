package com.bookmark.algo.stack;

/**
 * @author: hj
 * @date: 2021-09-14 19:33
 * @description: 用栈实现浏览器的前进和后退功能
 **/

public class StackOnBrowser {
    /**
     * 当前页面
     */
    private String currentPage;

    /**
     * 前进操作时，从该栈中取出地址
     */
    private LinkedListBaseStack aheadStack;

    /**
     * 后退操作时，从该栈中取出地址
     */
    private LinkedListBaseStack backStack;

    public StackOnBrowser() {
        this.aheadStack = new LinkedListBaseStack();
        this.backStack = new LinkedListBaseStack();
    }

    /**
     * 前进操作
     */
    public void goAhead() {
        // 从 aheadStack 中取出一个地址
        if (aheadStack != null) {
            String url = aheadStack.pop();
            // 将当前页面存入到backStack中
            backStack.push(currentPage);
            this.currentPage = url;
        }
    }

    /**
     * 后退操作
     */
    public void goBack() {
        if (backStack != null) {
            String url = backStack.pop();
            aheadStack.push(currentPage);
            this.currentPage = url;
        }
    }

    /**
     * 打开新的网页
     */
    public void openNew(String url) {
        // 打开新的网页需要把aheadStack清空，因为此时打开新的网页了，相当于是重置了前进操作
        aheadStack.clear();
        backStack.push(currentPage);
        this.currentPage = url;
    }

    public void showCurrentPage() {
        System.out.println("currentPage: " + this.currentPage);
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

        public void clear() {
            this.top = null;
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

    public static void main(String[] args) {
        StackOnBrowser browser = new StackOnBrowser();
        browser.openNew("aaa");
        browser.openNew("bbb");
        browser.openNew("ccc");
        browser.goBack();
        browser.goAhead();
        browser.showCurrentPage();
    }
}
