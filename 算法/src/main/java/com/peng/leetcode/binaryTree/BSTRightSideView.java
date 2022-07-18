package com.peng.leetcode.binaryTree;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 199-二叉树的右视图
 * 给定一个二叉树的 根节点 root，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。
 */
public class BSTRightSideView {


    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

        private List<Integer> res = new LinkedList<>();

        public List<Integer> rightSideView(TreeNode root) {
//            bfs(root);
            dfs(root,0);
            return res;
        }

    public static void main(String[] args) {
        Integer i = 1;
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1);
        queue.offer(2);
        queue.offer(4);
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.size());
        System.out.println(queue.poll());
    }

    public void dfs(TreeNode root,int depth){
//            1. DFS 遍历树
//            2. 根右左的方式遍历 保证每次遍历的第一个 都为右节点
//            设当前遍历的层级为 depth 则在此之前遍历的总节点数为 de
//            对于 遍历的所有节点 数 n 与树的深度 depth 有如下关系
        if (root == null){
            return;
        }
        if (depth == res.size()){
            res.add(root.val);
        }
        depth ++ ;
        dfs(root.right,depth);
        dfs(root.left,depth);
    }


    public void bfs (TreeNode root){
//      1. 广度优先遍历
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
//            2. 初始化根节点
        while(!queue.isEmpty()){
            //    3. 获取当前层级 节点数量
            int size = queue.size();
            while(size > 0){
                TreeNode node  =  queue.poll();
                if(node == null){
                    break;
                }
                if (node.left!=null){
                    queue.offer(node.left);
                }
                if (node.right!=null){
                    queue.offer(node.right);
                }
                if ( size == 1){
                    res.add(node.val);
                }
                size--;
            }
        }
    }
}
