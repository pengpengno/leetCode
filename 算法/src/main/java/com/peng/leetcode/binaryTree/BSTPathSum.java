package com.peng.leetcode.binaryTree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 112 路径总和
 * 给你二叉树的根节点 root 和一个整数目标和 targetSum ，找出所有 从根节点到叶子节点 路径总和等于给定目标和的路径。
 *
 * 叶子节点 是指没有子节点的节点。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/path-sum-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class BSTPathSum {
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

    Deque<Integer> path = new LinkedList<Integer>();

    private List<List<Integer>> res = new ArrayList();

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        //        1.dfs 遍历二叉树
        dfs(root, targetSum);
        return res;


    }

    public void dfs (TreeNode root,int targetSum){
        if (root==null){
            return;
        }
        targetSum -= root.val;
//       插入当前的值
        path.offerLast(root.val);
        //        . 核心逻辑判断
        if(root.left == null && root.right ==null && targetSum == 0){
            res.add(new ArrayList<>(path));
        }
        dfs(root.left,targetSum);
        dfs(root.right,targetSum);
//        每个节点的 遍历完成后将当前节点周期双端队列清除
        path.pollLast(); //回溯

    }
    /**
     * dfs 模板
     *         if (root==null){
     *             return;
     *         }
     *     TODO 进行逻辑操作
     *     TODO核心逻辑判断
     *     dfs(root.left,targetSum); 中序遍历 前序后序等都可
     *     dfs(root.right,targetSum);
     *     TODO 依据业务情况判断是否需要清除当前递归层的局部变量  （回溯）
     *
     */
//TODo  晚上写
    public void bsf(){

    }


}
