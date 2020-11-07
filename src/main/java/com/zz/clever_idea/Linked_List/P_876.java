package com.zz.clever_idea.Linked_List;

/**
 * https://leetcode-cn.com/problems/middle-of-the-linked-list/
 * 快慢指针
 *
 */
public class P_876 {
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }
    public ListNode middleNode(ListNode head) {
        if (head == null) return null;
        ListNode pre = head;
        ListNode cur = head.next;
        if (cur == null) return pre;
        while(cur.next != null){
            pre = pre.next;
            if (cur.next.next != null){
                cur = cur.next.next;
            }else{
                return pre;
            }
        }
        return pre.next;
    }
    public ListNode middleNode2(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }


}
