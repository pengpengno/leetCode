package com.peng.leetcode;

import com.peng.leetcode.binaryTree.BSTPathSum;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public  class TreeNode {
    public  int val;
    public TreeNode left;
    public TreeNode right;

    TreeNode() {
    }

    public TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
//    public TreeNode bfsAddArray(int[] array){
//        if (array == null || array.length == 0){
//            return null;
//        }
//        Queue<Integer> queue = new LinkedList<>();
//        for (int da :array){
//            queue.add(da);
//        }
//        TreeNode root = new TreeNode(queue.poll());
//        TreeNode temp = root;
//        while (!queue.isEmpty()){
//            Integer data = queue.poll();
//            if (temp.left == null){
//                temp.left = new TreeNode(data);
//            }
//            else if(temp.right == null){
//                temp.right = new TreeNode(data);
//            }else if (temp.left == null && temp.right != null){
//
//            }
//
//        }
//        return root;
//    }

    public void addTreeNode(TreeNode root,TreeNode left,TreeNode right){
        root.left = left;

    }
//    public TreeNode arrayToTree(int[] array){
//        if (array == null){
//            return new TreeNode();
//        }
//        TreeNode root = new TreeNode(array[0]);
//        for (int i = 1 ; i< array.length;i++){
//
//        }
//        return
//    }

    
}