package com.zz.clever_idea.Linked_List;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/palindrome-linked-list/
 * 优化思路：快慢指针，链表翻转
 *
 */
public class P_234 {
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }
    public boolean isPalindrome(ListNode head) {
        Stack<Integer> st = new Stack<>();
        List<Integer> list = new ArrayList<>();
        while(head!=null){
            st.push(head.val);
            list.add(head.val);
            head = head.next;
        }
        for(int i = 0;i<list.size();i++){
            if (list.get(i).intValue() != st.pop().intValue()){
                return false;
            }
        }
        return true;
    }
}
