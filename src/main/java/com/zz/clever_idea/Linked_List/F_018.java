package com.zz.clever_idea.Linked_List;


/**
 * https://leetcode-cn.com/problems/shan-chu-lian-biao-de-jie-dian-lcof/
 * 删除链表指定值
 * while(head != null && head.next != null){
 * 注意链表头和链表尾出现相等val
 *
 */
public class F_018 {
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }
    public ListNode deleteNode(ListNode head, int val) {
        if (head == null) return null;
        ListNode root = head;
        while (head.val == val){
            head = head.next;
            root = head;
        }
        if (head == null) return null;
        while(head != null && head.next != null){
            if (head.next.val == val){
                head.next = head.next.next;
            }
            head = head.next;
        }
        return root;
    }
}
