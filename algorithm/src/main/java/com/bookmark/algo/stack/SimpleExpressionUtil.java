package com.bookmark.algo.stack;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

/**
 * @author: hj
 * @date: 2021-09-15 16:10
 * @description: 定义一个表达式判断工具，用来判断表达式中的括号是否违法 为了简化题目，表达式中只包含三种类型的括号 {} () []
 **/

public class SimpleExpressionUtil {
    private final char[] leftBrackets = {'(', '{', '['};
    private final char[] rightBrackets = {')', '}', ']'};

    private static Map<Character, Character> bracketMap = null;

    public boolean checkExpression(String exp) {
        // 将字符串转为字符数组，然后轮询放入到栈中
        if (StringUtils.isEmpty(exp)) {
            return false;
        }
        char[] strArr = exp.toCharArray();
        StackBasedOnLinkedList container = new StackBasedOnLinkedList();
        // 循环字符数组，从左依次遍历数组中的每一个元素，如果是左括号则入栈，如果是右括号，则取出栈顶的元素判断是否匹配
        for (char c : strArr) {
            for (char left : leftBrackets) {
                if (c == left) {
                    container.push(c);
                    continue;
                }
            }
            for (char right : rightBrackets) {
                if (c == right) {
                    Character left = container.pop();
                    if (isMatch(left, c)) {
                        continue;
                    } else {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public boolean isMatch(char left, char right) {
        if (bracketMap == null) {
            bracketMap = new HashMap<>();
            bracketMap.put('{', '}');
            bracketMap.put('(', ')');
            bracketMap.put('[', ']');
        }
        Character rightBracket = bracketMap.get(left);
        if (right == rightBracket) {
            return true;
        }
        return false;
    }

    /**
     * 定义一个栈
     */
    private static class StackBasedOnLinkedList {

        private Node top = null;

        public StackBasedOnLinkedList(char data) {
            Node node = new Node(data, null);
            top = node;
        }

        public StackBasedOnLinkedList() {}

        /**
         * 入栈
         *
         * @return
         */
        public boolean push(char data) {
            Node newNode = new Node(data, top);
            newNode.next = top;
            top = newNode;
            return false;
        }

        /**
         * 出栈
         *
         * @return
         */
        public Character pop() {
            if (top == null) {
                return null;
            } else {
                char data = top.data;
                top = top.next;
                return data;
            }
        }

    }

    private static class Node {
        private char data;
        private Node next;

        /**
         * 构造函数
         * 
         * @param data
         * @param next
         */
        public Node(char data, Node next) {
            this.data = data;
            this.next = next;
        }

    }

    public static void main(String[] args) {

        SimpleExpressionUtil simpleExpressionUtil = new SimpleExpressionUtil();
        boolean b = simpleExpressionUtil.checkExpression("(({{[[]]}}))");
        System.out.println("b = " + b);
    }
}
