package com.kingfsen.arithmetic;

/**
 * 字典树
 * A-Z ascii码范围65~90
 * a-z ascii码范围97-122
 * Assume all word characters range a~z
 */
public class Trie {

    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        if (word == null || word.length() == 0) {
            return;
        }
        TrieNode node = root;
        int index;
        char[] chars = word.toCharArray();
        for (int i=0;i<chars.length;i++) {
            index = chars[i] - 'a';
            if (node.map[index] == null) {
                node.map[index] = new TrieNode();
            }
            node = node.map[index];
            node.path++;
        }
        node.end++;
    }

    public boolean search(String word) {
        if (word == null || word.length() == 0) {
            return false;
        }
        TrieNode node = root;
        int index;
        char[] chars = word.toCharArray();
        for (int i=0;i<chars.length;i++) {
            index = chars[i] - 'a';
            if (node.map[index] == null) {
                return false;
            }
            node = node.map[index];
        }
        return node.end != 0;
    }

    public void delete(String word) {
        if (word == null || word.length() == 0) {
            return;
        }
        TrieNode node = root;
        int index;
        char[] chars = word.toCharArray();
        for(int i=0;i<chars.length;i++) {
            index = chars[i] - 'a';
            if (node.map[index].path-- == 1) {
                node.map[index] = null;
                return;
            }
            node = node.map[index];
        }
        node.end--;
    }

    public int prefixCount(String pre) {
        if (pre == null || pre.length() == 0) {
            return 0;
        }
        TrieNode node = root;
        int index;
        char[] chars = pre.toCharArray();
        for (int i=0;i<chars.length;i++) {
            index = chars[i] - 'a';
            if (node.map[index] == null) {
                return 0;
            }
            node = node.map[index];
        }
        return node.path;
    }

    public static void main(String[] args) {
        Trie t = new Trie();
        t.insert("iloveyou");
        t.insert("iloveme");
        t.insert("iloveyouverymuch");
        t.insert("iloveyouwife");
        t.insert("youloveme");
        t.insert("youlovemesomuch");
        System.out.println(t.prefixCount("ilove"));
        t.delete("iloveme");
        System.out.println(t.prefixCount("ilove"));
    }

}

class TrieNode {

    public int path;

    public int end;

    public TrieNode[] map;

    public TrieNode() {
        map = new TrieNode[26];
    }
}
