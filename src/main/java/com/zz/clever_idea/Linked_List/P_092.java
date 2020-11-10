package com.zz.clever_idea.Linked_List;

import java.util.List;
import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/reverse-linked-list-ii/
 *
 * 反转从位置 m 到 n 的链表。请使用一趟扫描完成反转。
 * 说明:
 * 1 ≤ m ≤ n ≤ 链表长度。
 *
 * 示例:
 * 输入: 1->2->3->4->5->NULL, m = 2, n = 4
 * 输出: 1->4->3->2->5->NULL
 *
 */
public class P_092 {

    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    /**
     * 1  ->  2  ->  3  ->  4  ->  5  ->  NULL
     * null  ->  1  ->  2  ->  3  ->  4  ->  5  ->  NULL
     *  pre      cur
     *  null  ->  1  ->  2  ->  3  ->  4  ->  5  ->  NULL
     *           pre    cur
     *            l      r
     *  null  ->  1  ->  2  <-  3      4  ->  5  ->  NULL
     *            l      r
     *                  pre    cur     t
     *                         pre    cur
     *  null  ->  1  ->  2  <-  3  <-  4      5  ->  NULL
     *            l      r
     *                         pre    cur     t
     *                                pre    cur
     *  null  ->  1  ->  2  <-  3  <-  4      5  ->  NULL
     *            l      r
     *  null  ->  1  ->  4  ->  3  ->  2      5  ->  NULL
     *  null  ->  1  ->  4  ->  3  ->  2  ->  5  ->  NULL
     *
     *
     * @param head
     * @param m
     * @param n
     * @return
     */
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null) return null;
        ListNode pre = null;
        ListNode cur = head;
        while(m>1){
            pre = cur;
            cur = cur.next;
            m--;
            n--;
        }
        ListNode l = pre;
        ListNode rNext = cur;
        while(n>0){
            ListNode t = cur.next;
            cur.next = pre;
            pre = cur;
            cur = t;
            n--;
        }
        if (l != null){
            l.next = pre;
        }else{
            head = pre;
        }
        rNext.next = cur;
        return head;
    }
}
