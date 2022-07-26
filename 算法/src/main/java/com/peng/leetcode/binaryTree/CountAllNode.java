package com.peng.leetcode.binaryTree;

import com.peng.leetcode.TreeNode;

/**
 * 222-完全二叉树的节点个数
 */
public class CountAllNode {

    public int countNodes(TreeNode root) {
        return dfs(root,-1);
    }

    public int dfs(TreeNode root,int num){
        // 由于当节点为空时候也会进行 一次递归操作 但此操作是无效的额 所以在输入的时候 需要指定为-1
        if (root == null){
            return num+1;
        }
        int dfs = dfs(root.left, num);
        int dfs1 = dfs(root.right, dfs);
        return dfs1;
    }
}
