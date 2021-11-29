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
        Map<String, String> dic = new HashMap<>();
        dic.put(")","(");
        dic.put("]","[");
        dic.put("}","{");
        final char[] chars = s.toCharArray();
        final LinkedList<String> stack = new LinkedList<>();
        for (int i = 0; i < chars.length; i++) {
            final String value = String.valueOf(chars[i]);
            if (dic.containsKey(value)) {
                if (stack.isEmpty() || !stack.pop().equals(dic.get(value))) {
                    return false;
                }
            }else {
                stack.push(value);
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        final boolean valid = isValid("()");
    }
}
