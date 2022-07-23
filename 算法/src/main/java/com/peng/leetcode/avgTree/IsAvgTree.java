package com.peng.leetcode.avgTree;

import com.peng.leetcode.TreeNode;
import com.peng.leetcode.binaryTree.BinarySearchTreeRecover;

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

    /**
     * 递归处理
     * 1、 找到叶子节点
     * 2. 判断叶子节点  k与 树的深度depth 是否满足 depth - k < 1
     *
     * @param root
     * @return
     */
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
        int depth = 1;
        int noChildLevel = 1;
        int avg ;
        queue.offer(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            depth++;
            avg = depth-noChildLevel;
            while( size > 0){
                TreeNode poll = queue.poll();
                if (noChildLevel != 1 && avg <= 1){
                    return false;
                }
                if (poll == null){
                    continue;
                }
                if (poll.left == null && poll.right == null){
                    if (noChildLevel != 1){
                        continue;
                    }
                    noChildLevel = depth;
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

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode treeNode1 = new TreeNode(2);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode4 = new TreeNode(3);
        TreeNode treeNode5 = new TreeNode(4);
        TreeNode treeNode6 = new TreeNode(4);
//        TreeNode treeNode3 = new TreeNode(20);
//        TreeNode treeNode4 = new TreeNode(null);
//        TreeNode treeNode5 = new TreeNode(4);
//        TreeNode treeNode6 = new TreeNode(4);
        root.left = treeNode1;
        root.right = treeNode2;
        treeNode1.left = treeNode3;
        treeNode1.right = treeNode4;

        treeNode2.left=null;
        treeNode2.right=null;

        treeNode3.left = treeNode5;
        treeNode3.right = treeNode6;
        IsAvgTree isAvgTree = new IsAvgTree();
        System.out.println(isAvgTree.isBalanced(root));
//        treeNode3.right = treeNode4;
//        treeNode4.left = treeNode2;
        System.out.println(treeNode3);
    }
}
