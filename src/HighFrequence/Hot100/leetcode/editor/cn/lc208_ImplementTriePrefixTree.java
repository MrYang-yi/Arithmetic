package HighFrequence.Hot100.leetcode.editor.cn;

/**
 * 数组长度为 26，即小写英文字母的数量,布尔字段isEnd，表示该节点是否为字符串的结尾
 */
public class lc208_ImplementTriePrefixTree {
    private lc208_ImplementTriePrefixTree[] children;
    private boolean isEnd;

    public lc208_ImplementTriePrefixTree() {
        children = new lc208_ImplementTriePrefixTree[26];
        isEnd = false;
    }

    public void insert(String word) {
        lc208_ImplementTriePrefixTree node = this;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            int index = ch - 'a';
            if (node.children[index] == null) {
                node.children[index] = new lc208_ImplementTriePrefixTree();
            }
            node = node.children[index];
        }
        node.isEnd = true;
    }

    public boolean search(String word) {
        lc208_ImplementTriePrefixTree node = searchPrefix(word);
        return node != null && node.isEnd;
    }

    public boolean startsWith(String prefix) {
        return searchPrefix(prefix) != null;
    }

    private lc208_ImplementTriePrefixTree searchPrefix(String prefix) {
        lc208_ImplementTriePrefixTree node = this;
        for (int i = 0; i < prefix.length(); i++) {
            char ch = prefix.charAt(i);
            int index = ch - 'a';
            if (node.children[index] == null) {
                return null;
            }
            node = node.children[index];
        }
        return node;
    }
}