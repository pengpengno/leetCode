package com.peng.leetcode.binaryTree;

/**
 * 208前缀树
 */
public class TriePrefix {
        // 1. 构造前缀树节点trieNode
        private  class Node{
            private boolean isEnd;
            private  Node[] childNode ;
            public Node(){
                childNode = new Node[26];
            }
        }

        private Node node;
// 1.  构造前缀树根节点
        public TriePrefix() {
            node = new Node(); // 构造根节点
        }

//1.
        public void insert(String word) {
            char[] chars = word.toCharArray();
            Node tem = node;
            for (char ch :chars){
                int index =  ch - 'a';
                if(tem.childNode[index] == null){
                    tem.childNode[index] = new Node();
                }
                tem = tem.childNode[index];
            }
            tem.isEnd = true;

        }

        public boolean search(String word) {
            char[] chars = word.toCharArray();
            Node tem = node;
            for(char ch : chars){
                int index = ch - 'a';
                if (tem.childNode[index] == null){
                    return false;
                }
                tem = tem.childNode[index];
            }
            return tem.isEnd;
        }

        public boolean startsWith(String prefix) {
            char[] chars = prefix.toCharArray();
            Node tem = node;
            for(char ch : chars){
                int index = ch - 'a';
                if (tem.childNode[index] == null){
                    return false;
                }
                tem = tem.childNode[index];
            }
            return true;

        }

    /**
     * Your Trie object will be instantiated and called as such:
     * Trie obj = new Trie();
     * obj.insert(word);
     * boolean param_2 = obj.search(word);
     * boolean param_3 = obj.startsWith(prefix);
     */
    public static void main(String[] args) {

        TriePrefix triePrefix = new TriePrefix();

        triePrefix.insert("wangpeng");
        System.out.println(triePrefix.search("wwwww"));
        System.out.println(triePrefix.search("wangpeng"));
        System.out.println(triePrefix.startsWith("w"));
        System.out.println(triePrefix.startsWith("wang"));
    }
}
