package com.zz.clever_idea.Linked_List;

import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/convert-binary-number-in-a-linked-list-to-integer/
 * 位运算
 */
public class P_1290 {
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }
    public int getDecimalValue(ListNode head) {
        int idx = 0;
        int ans = 0;
        Stack<Integer> st = new Stack<>();
        while (head!=null){
            st.push(head.val);
            head = head.next;
        }
        while (!st.empty()){
            if (st.pop() == 1){
                ans += 1<<idx;
            }
            idx++;
        }
        return ans;
    }
    public int getDecimalValue2(ListNode head) {
        int idx = 0;
        int ans = 0;
        while (head!=null){
            ans = ans*2 + head.val;
            head = head.next;
        }
        return ans;
    }

}
