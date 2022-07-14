package com.peng.leetcode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 19 删除链表的倒数第N个节点并返回其头节点
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
public class DeleteNthFormLinkList {

  private static class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

    /**
     * 快慢指针
     * 1. quick  快指针 slow 慢指针
     *  在开始 同步步增之前 快指针先 系统 N 位，开始后当快指针移动到链表尾部时  慢指针刚好到达 目标位置（倒数第N位）
     *
     * @param node
     * @param n
     * @return
     */
    public static ListNode rmNthNode(ListNode node ,int n){
        ListNode head = new ListNode(-2,node);

        ListNode quick = head;
        ListNode slow = head;
        for (int i=0;i<n;i++){
          quick = quick.next;
        }
//        循环查看下一节点是否为空
        while(null != quick.next){
            quick = quick.next;
            slow = slow.next;
        }
        slow.next =  slow.next.next;
        return head.next;
    }
    /**
     * 栈 实现
     * 所有节点推入栈中 自顶向下
     * 每次弹出一个 node 第N个即为需要处理的数据
     *
     * @param node
     * @param n
     * @return
     */
    public static ListNode rmNthNode2(ListNode node ,int n){
        ListNode head  = new ListNode(0, node);
        ListNode cur  = head;

        Deque<ListNode> stack = new LinkedList<ListNode>();
        while(null != cur){
            stack.push(cur);
            cur = cur.next;
        }
        for (int i = 0 ; i< n ; i++){
            stack.pop();
        }
        ListNode pre = stack.peek();
        if (null == pre){
            return null;
        }
        pre.next = pre.next.next;
        return head.next;
    }
    public static void main(String[] args) {
        ListNode tem = new ListNode();
        ListNode header = new ListNode(8,tem);
        ListNode listNode = new ListNode(0,tem);
        for (int i= 1 ;i<6;i++){
            tem.val = i;
            tem.next = new ListNode(i+1);
            tem = tem.next;
//            ListNode temNode = new ListNode(i);
//            tem = listNode.next;
        }
        System.out.println(tem);
        ListNode listNode2 = new ListNode(1);
        ListNode listNode1 = rmNthNode2(header.next, 3);
//        ListNode testNode2 = rmNthNode(listNode2, 1);
        ListNode testNode2 = rmNthNode2(listNode2, 1);
//        System.out.println(listNode1);
        System.out.println(testNode2);
        System.out.println(header.next);
        System.out.println(header.next);
        System.out.println(header.next);

    }
}
