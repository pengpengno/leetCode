package com.peng.leetcode.binaryTree;

import java.util.*;

/**
 * 236-二叉树的最近公共祖先
 * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
 *
 * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个节点 p、q，最近公共祖先表示为一个节点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/lowest-common-ancestor-of-a-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LowestCommonAncestorBST {

    private static class TreeNode {
     int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
    }

    private static HashMap<Integer,TreeNode> PathQueue  = new HashMap<>();
    private static Set<Integer>  parentSet = new HashSet<>();

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        dfs(root);  // dfs 遍历树 维护树字符节点关系的HAsh表
        while(p != null){
            parentSet.add(p.val);
            p = PathQueue.get(p.val);
        }
        while (q !=null){
            if (parentSet.contains(q.val)){
                return q;
            }
            q = PathQueue.get(q.val);
        }
        return null;
    }

    public void dfs(TreeNode root){
//        遍历左子树 若不为空 则 建立 左节点left 和当前根节点root的映射关系
          if (root.left != null){
              PathQueue.put(root.left.val,root);
              dfs(root.left);
          }
//          同上  左子树原理
          if (root.right != null){
              PathQueue.put(root.right.val,root);
              dfs(root.right);
          }
    }
}
