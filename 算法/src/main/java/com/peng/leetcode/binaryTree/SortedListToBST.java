package com.peng.leetcode.binaryTree;

public class SortedListToBST {


      private static class ListNode {
          int val;
          ListNode next;
          ListNode() {}
          ListNode(int val) { this.val = val; }
          ListNode(int val, ListNode next) { this.val = val; this.next = next; }
      }
    private static class TreeNode {
             int val;
             TreeNode left;
             TreeNode right;
             TreeNode() {}
             TreeNode(int val) { this.val = val; }
             TreeNode(int val, TreeNode left, TreeNode right) {
                 this.val = val;
                 this.left = left;
                 this.right = right;
             }
      }

    public static TreeNode sortedListBST(ListNode head){
        return getTreeDfs(head,null);
    }

//深度
    public static TreeNode getTreeDfs(ListNode head ,ListNode tail){
          if (head == tail){
              return null;
          }
        //          1. 找到中间节点
        ListNode midNode = getMidNode(head,tail);
//        获取到中间节点slow
//        递归继续 获取中间节点
        TreeNode root =  new TreeNode(midNode.val);
        root.left = getTreeDfs(head,midNode);
        root.right = getTreeDfs(midNode.next,tail);
        return root;
    }

    public static ListNode getMidNode(ListNode  head,ListNode tail){
        ListNode quick = head;
        ListNode slow = head;
        while(quick.next != tail && quick.next.next !=tail ){
            slow = slow.next;
            quick = quick.next.next;
        }
        return slow;
    }

    public static void main(String[] args) {
        ListNode treeNode1 = new ListNode(1);
        ListNode treeNode2 = new ListNode(2);
        ListNode treeNode3 = new ListNode(3);
        ListNode treeNode4 = new ListNode(4);
        treeNode1.next = treeNode2;
        treeNode2.next = treeNode3;
        treeNode3.next = treeNode4;
        TreeNode treeNode = sortedListBST(treeNode1);
        System.out.println(treeNode);
    }
}
