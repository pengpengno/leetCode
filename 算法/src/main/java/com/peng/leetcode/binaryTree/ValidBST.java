package com.peng.leetcode.binaryTree;


public class ValidBST {
//    private static Long MIN_NUMS  = Long.MIN_VALUE;
    private static TreeNode pre = new TreeNode(Integer.MIN_VALUE);

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

    public boolean isValidBST(TreeNode root) {
//        1. 中序遍历树
        //    2. 判断是否为大于小于上一节点值弹出当前遍历节点val
//        2.1 如果为中序遍历的第一个节点 则以 LONG 最小值进行比较
        if (root == null){
            return true;
        }
        if (!isValidBST(root.left)){
            return false;
        }
        if (root.val <= pre.val ){
            return false;
        }
        pre = root;

        return isValidBST(root.right);
    }
}
