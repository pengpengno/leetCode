package com.peng.leetcode.backstack;

import com.peng.leetcode.ListNode;

/**
 * 24-两两交换链表中的节点
 * 给你一个链表，两两交换其中相邻的节点，并返回交换后链表的头节点。你必须在不修改节点内部的值的情况下完成本题（即，只能进行节点交换）。
 */
public class ChangeLinkedLIst {

    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = head.next;
        head.next = swapPairs(newHead.next);
        newHead.next = head;
        return newHead;
    }

    public static void main(String[] args) {
//        ChangeLinkedLIst changeLinkedLIst = new ChangeLinkedLIst();
//        changeLinkedLIst.swapPairs()
    }


}
