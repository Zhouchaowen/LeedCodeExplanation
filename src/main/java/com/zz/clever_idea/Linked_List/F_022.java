package com.zz.clever_idea.Linked_List;

import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/lian-biao-zhong-dao-shu-di-kge-jie-dian-lcof/
 * 输入一个链表，输出该链表中倒数第k个节点。为了符合大多数人的习惯，本题从1开始计数，
 * 即链表的尾节点是倒数第1个节点。例如，一个链表有6个节点，从头节点开始，
 * 它们的值依次是1、2、3、4、5、6。这个链表的倒数第3个节点是值为4的节点。
 * 示例：
 * 给定一个链表: 1->2->3->4->5, 和 k = 2.
 * 返回链表 4->5.
 *
 * stack
 * 思考有没有 空间O(1)? 双指针
 *
 */
public class F_022 {
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }
    public ListNode getKthFromEnd(ListNode head, int k) {
        if (head == null) return null;
        Stack<ListNode> st = new Stack<>();
        while (head != null){
            st.push(head);
            head = head.next;
        }
        for (int i = 1;i<k;i++){
            st.pop();
        }
        return st.pop();
    }

    public ListNode getKthFromEnd2(ListNode head, int k) {
        if (head == null) return null;
        ListNode pre = head;
        ListNode cur = head;
        for(int i = 1;i<=k;i++){
            head = head.next;
            cur = head;
        }
        while (cur != null){
            pre = pre.next;
            cur = cur.next;
        }
        return pre;
    }

}
