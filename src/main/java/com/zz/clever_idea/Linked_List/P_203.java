package com.zz.clever_idea.Linked_List;

/**
 * https://leetcode-cn.com/problems/remove-linked-list-elements/
 * 哨兵
 * 考虑链表头一开始是相等的情况
 *
 */
public class P_203 {
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }
    public ListNode removeElements(ListNode head, int val) {
        if (head == null)return null;
        ListNode t = head;
        while(head != null && head.val == val){
            head = head.next;
            t = head;
        }
        if (t == null){
            return t;
        }
        while(head.next != null){
            if (head.next.val == val){
                head.next = head.next.next;
                continue;
            }
            head = head.next;
        }
        return t;
    }
}
