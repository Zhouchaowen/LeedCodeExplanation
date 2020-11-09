package com.zz.clever_idea.Linked_List;

/**
 * https://leetcode-cn.com/problems/kth-node-from-end-of-list-lcci/
 *
 *实现一种算法，找出单向链表中倒数第 k 个节点。返回该节点的值。
 *
 * 注意：本题相对原题稍作改动
 * 示例：
 * 输入： 1->2->3->4->5 和 k = 2
 * 输出： 4
 * 说明：
 * 给定的 k 保证是有效的。
 *
 * 同剑指Offer22题-F_022
 *
 */
public class X_002 {
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }
    public int kthToLast(ListNode head, int k) {
        if (head == null) return 0;
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
        return pre.val;
    }
}
