package com.zz.clever_idea.Linked_List;

/**
 * https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list/
 * 去重重复元素
 *
 */
public class P_083 {
    class ListNode {
        int val;
        ListNode next;
        ListNode() {
            next = null;
        }
    }
    public ListNode deleteDuplicates(ListNode head) {
        ListNode p = new ListNode();
        p.val = head.val;
        p.next = null;
        ListNode he = p;
        while(head.next != null){
            if(p.val == head.val){
                head = head.next;
            }else{
                ListNode t = head;
                p.next = t;
                p = p.next;
                head = head.next;
            }
        }
        return he;
    }
}
