package com.peng.leetcode.avgTree;

import com.peng.leetcode.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 110. 平衡二叉树
 * 给定一个二叉树，判断它是否是高度平衡的二叉树。
 *
 * 本题中，一棵高度平衡二叉树定义为：
 *
 * 一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1 。
 */
public class IsAvgTree {

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode() {}
     *     TreeNode(int val) { this.val = val; }
     *     TreeNode(int val, TreeNode left, TreeNode right) {
     *         this.val = val;
     *         this.left = left;
     *         this.right = right;
     *     }
     * }
     */

    public boolean isBalanced(TreeNode root) {
        return bfs(root);
    }


    public int height(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);
        if (leftHeight == -1 || rightHeight == -1 || Math.abs(leftHeight - rightHeight) > 1) {
            return -1;
        } else {
            return Math.max(leftHeight, rightHeight) + 1;
        }
    }

    public boolean bfs(TreeNode root){
        Queue<TreeNode>  queue = new LinkedList<>();
        int depth = 0;
        int noChild = 0;
        int avg ;
        queue.offer(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            depth++;
            while(size>0){
                avg = depth-noChild;
                TreeNode poll = queue.poll();
                if (noChild!=0 && avg > 1){
                    return false;
                }
                if (poll == null){
                    noChild = depth;
                }
                if (poll.left ==null && poll.right ==null){
                    noChild = depth;
                }
                if (poll.left!=null){
                    queue.offer(poll.left);
                }
                if (poll.right !=null){
                    queue.offer(poll.right);
                }
                size--;
            }
        }
        return true;
    }
}
