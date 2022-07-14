package com.peng.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 99 恢复二叉搜索树
 * 给你二叉搜索树的根节点 root ，该树中的 恰好 两个节点的值被错误地交换。请在不改变其结构的情况下，恢复这棵树 。
 */
public class BinarySearchTreeRecover {
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

    /**
     * 1. 中序遍历树 输出节点列表
     * 2. 找出 节点排序错误的节点
     * 3. 交换错误节点val
     * @param root
     */
  public static void recoverTree(TreeNode root){
//      1. 中序遍历树 输出节点列表
      List<TreeNode> nodeList = new ArrayList<>();
      dfsBinaryTree(root,nodeList);

//      2. 对于二叉搜索树中 中序遍历后列表 中的节点i(i> = 0) 总有 list[i]<list[i+1]
//      Integer quick = 1;
      int slow = 0 ;
      int length = nodeList.size();
      TreeNode errorFir = null;
      TreeNode errorSec = null;
      while(slow < length-1){
          TreeNode curNode = nodeList.get(slow);
          TreeNode nextNode = nodeList.get(slow+1);
          if (curNode.val > nextNode.val){
              if (errorSec == null){
                  errorSec = curNode;
                  continue;
              }
              else{
                  errorFir = nextNode;
              }
          }
          slow++;
      }
      if (errorFir != null){
          errorFir.val = errorSec.val+errorFir.val;
          errorSec.val = errorFir.val-errorSec.val;
          errorFir.val = errorFir.val-errorSec.val;
      }

  }
  public static void dfsBinaryTree(TreeNode root,List<TreeNode> treeNodes){
      if (root== null){
          return;
      }
      dfsBinaryTree(root.left,treeNodes);
      treeNodes.add(root);
      dfsBinaryTree(root.right,treeNodes);
  }

    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode4 = new TreeNode(4);
        treeNode3.left = treeNode1;
        treeNode3.right = treeNode4;
        treeNode4.left = treeNode2;
        recoverTree(treeNode3);
        System.out.println(treeNode3);
    }


}
