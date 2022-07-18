package com.peng.leetcode.binaryTree;

import java.util.ArrayList;
import java.util.List;

/**
 * 235. 二叉搜索树的最近公共祖先
 * 给定一个二叉搜索树, 找到该树中两个指定节点的最近公共祖先。
 *
 * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 *
 * 例如，给定如下二叉搜索树:  root = [6,2,8,0,4,7,9,null,null,3,5]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/lowest-common-ancestor-of-a-binary-search-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LowestCommonAncestor {
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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        ArrayList<TreeNode> resP = new ArrayList<>();
        ArrayList<TreeNode> resQ = new ArrayList<>();
        dfsGetPath(root,resP,p);
        dfsGetPath(root,resQ,q);
        int min = Math.min(resP.size(), resQ.size());

        TreeNode ancestor = root; // 默认最近公共祖先为父节点
        int index = 0;

        while (index < min){
            if(resP.get(index) == resQ.get(index)){
                ancestor = resP.get(index);
            }
            index++;
        }
        return ancestor;
    }


    public List<TreeNode> dfsGetPath (TreeNode root,List<TreeNode> res ,TreeNode target){

        if (root == null){
            return res;
        }
        if (root.val != target.val){
            res.add(root);
            if (root.val > target.val){
                dfsGetPath(root.left,res,target);
            }

            if (root.val < target.val){
                dfsGetPath(root.right,res,target);
            }

        }
        else {
            res.add(root);
            return res;
        }
        return res;
    }
}
