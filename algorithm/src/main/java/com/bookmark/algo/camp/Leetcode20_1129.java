package com.bookmark.algo.camp;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * @author: hj
 * @date: 2021-11-29 22:58
 * @description: <p>
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
 * <p>
 * 有效字符串需满足：
 * <p>
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * </p>
 **/

public class Leetcode20_1129 {
    /**
     * 遍历字符数组，遇到左括号则入栈，遇到右括号则拿出来和栈顶的元素进行比较
     * 如果匹配则出栈，如果不匹配则返回false
     *
     * @param s
     * @return
     */
    public static boolean isValid(String s) {
        //声明一个map用来保存括号之间的对应关系
        Map<String, String> dic = new HashMap<>(3);
        dic.put(")","(");
        dic.put("]","[");
        dic.put("}","{");
        final char[] chars = s.toCharArray();
        final LinkedList<String> stack = new LinkedList<>();
        for (int i = 0; i < chars.length; i++) {
            final String value = String.valueOf(chars[i]);
            //遇到右括号，则判断栈顶元素和右括号对应的左括号是否相等
            if (dic.containsKey(value)) {
                if (stack.isEmpty() || !stack.pop().equals(dic.get(value))) {
                    return false;
                }
            }else {
                //左括号入栈
                stack.push(value);
            }
        }
        return stack.isEmpty();
    }

    /**
     * 相较于1中的方法，这里使用字符包装类来保存元素，减少字符与字符串之间的相互转换
     * 入栈的方式也有调整，在左括号入栈之后，将其对应的右括号也入栈，当拿到右括号的时候，之间从栈顶取出一个
     *
     * @param s
     * @return
     */
    public static boolean isValid2(String s) {
        //特殊情况判断
        if (s.isEmpty() || s.length() % 2 == 1) {
            return false;
        }
        //声明一个map缓存对应关系
        Map<Character, Character> dic = new HashMap<>(3);
        dic.put('(', ')');
        dic.put('[', ']');
        dic.put('{', '}');

        //创建一个栈用来保存对应关系
        LinkedList<Character> stack = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            char value = s.charAt(i);
            //左括号入栈
            if (dic.containsKey(value)) {
                stack.push(value);
            } else {
                //右括号出栈比较
                if (stack.isEmpty() || value != dic.get(stack.pop())) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }


    public static void main(String[] args) {
        final boolean valid = isValid("()");
    }
}
