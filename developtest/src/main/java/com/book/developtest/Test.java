package com.book.developtest;

import java.util.*;

/**
 * @author: hj
 * @date: 2022-03-13 15:17
 * @description:
 **/

public class Test {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param words string字符串一维数组
     * @return string字符串
     */
    public static String longestWord(String[] words) {
        String ans = "";
        Set<String> wordSet = new HashSet<>();
        for (String word : words) {
            wordSet.add(word);
        }
        for (String word : words) {
            if (word.length() > ans.length()
                    || word.length() == ans.length() && word.compareTo(ans) < 0) {
                boolean flag = true;
                for (int k = 1; k < word.length(); ++k) {
                    if (!wordSet.contains(word.substring(0, k))) {
                        flag = false;
                        break;
                    }
                }
                if (flag) ans = word;
            }
        }
        return ans;
    }

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param words string字符串一维数组
     * @return string字符串
     */
    public static String longestWord1(String[] words) {
        final Trie trie = new Trie();
        int index = 0;
        for (String word : words) {

            trie.insert(word, ++index);
        }
        trie.words = words;
        return trie.dfs();

    }

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param words string字符串一维数组
     * @return string字符串
     */
    public static String longestWord2(String[] words) {
        Set<String> wordSet = new HashSet<>(Arrays.asList(words));

        //按照长度进行排序
        Arrays.sort(words, (a, b) -> a.length() ==
                b.length() ? a.compareTo(b) : b.length() - a.length());
        System.out.println("words = " + Arrays.toString(words));
        for (String word : words) {
            char[] cs = word.toCharArray();
            if (find(cs, 0, wordSet)) {
                return new String(cs);
            }

        }
        return "";
    }

    private static boolean find(char[] cs, int index, Set<String> set) {
        if (index == cs.length) {
            return true;
        }
        for (int i = index; i < cs.length; i++) {
            if (set.contains(new String(cs, index, i - index + 1))) {
                if (index == 0 && i == cs.length - 1) {
                    return false;
                }
                if (find(cs, i + 1, set)) {
                    return true;
                }
            }
        }
        return false;
    }

    static class Node {
        char c;
        HashMap<Character, Node> children = new HashMap<>();
        int end;

        public Node(char c) {
            this.c = c;
        }
    }

    static class Trie {
        Node root;
        String[] words;

        public Trie() {
            root = new Node('0');
        }

        public void insert(String word, int index) {
            Node cur = root;
            for (char c : word.toCharArray()) {
                cur.children.putIfAbsent(c, new Node(c));
                cur = cur.children.get(c);
            }
            cur.end = index;
        }

        public String dfs() {
            String ans = "";
            Stack<Node> stack = new Stack<>();
            stack.push(root);
            while (!stack.isEmpty()) {
                Node node = stack.pop();
                if (node.end > 0 || node == root) {
                    if (node != root) {
                        String word = words[node.end - 1];
                        if (word.length() > ans.length() || word.length() == ans.length() && word.compareTo(ans) < 0) {
                            ans = word;
                        }
                    }
                    for (Node nei : node.children.values()) {
                        stack.push(nei);
                    }
                }
            }
            return ans;
        }
    }


    public static void main(String[] args) {
        String[] arr = new String[]{"apple", "iOS", "dog", "nana", "man", "good", "goodman"};

        final String s = longestWord2(arr);
        System.out.println("s = " + s);
    }

}
