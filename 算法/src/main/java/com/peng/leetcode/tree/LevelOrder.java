package com.peng.leetcode.tree;

import java.util.*;

/**
 * 429-N 叉树的层序遍历
 */
public class LevelOrder {
    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    private Queue<Node> deque = new LinkedList<>();
    private List<List<Integer>>  result = new LinkedList<>();
    public List<List<Integer>> levelOrder(Node root) {
//        bfs 遍历
        if(root == null){
            return result;
        }
        deque.offer(root);
        while (!deque.isEmpty()){
            int size = deque.size();
            ArrayList<Integer> res = new ArrayList<>();
            while (size > 0){
                Node poll = deque.poll();
                if(poll == null){
                    size--;
                    continue;
                }
                res.add(poll.val);
                for(Node node : poll.children){
                    if (node!= null){
                        deque.offer(node);
                    }
                }
                size--;
            }
            result.add(res);

        }
        return result;
    }
}
