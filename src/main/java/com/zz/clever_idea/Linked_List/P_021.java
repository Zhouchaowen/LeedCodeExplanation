package com.zz.clever_idea.Linked_List;

/**
 * https://leetcode-cn.com/problems/merge-two-sorted-lists/
 *
 */
public class P_021 {
    /*
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode h = new ListNode(-1);
        ListNode ans = h;
        while(l1 != null && l2 != null){
            if(l1.val <= l2.val){
                h.next = l1;
                l1 = l1.next;
            }else{
                h.next = l2;
                l2 = l2.next;
            }
            h = h.next;
        }
        h.next = l1 == null?l2:l1;
        return ans.next;
    }
    */
}
