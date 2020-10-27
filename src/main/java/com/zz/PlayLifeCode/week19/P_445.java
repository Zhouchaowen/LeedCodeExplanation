package com.zz.PlayLifeCode.week19;

import java.util.Stack;

/**
 *
 * https://leetcode-cn.com/problems/add-two-numbers-ii/
 * 栈: 先进后出+进位
 *
 */
public class P_445 {
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<ListNode> a = new Stack<>();
        Stack<ListNode> b = new Stack<>();
        while(l1!=null){
            a.push(l1);l1 = l1.next;
        }
        while(l2!=null){
            b.push(l2);l2 = l2.next;
        }
        ListNode he = new ListNode(0);
        int jw = 0;
        while(!a.isEmpty() || !b.isEmpty()){
            int aV = 0,bV = 0;
            if(a.size()>0){
                aV = a.pop().val;
            }
            if(b.size()>0){
                bV = b.pop().val;
            }
            ListNode ln = new ListNode((aV+bV+jw)%10);
            jw += (aV+bV+jw)/10;
            if(he.next == null){
                he.next = ln;
            }else{
                ListNode t = he.next;
                he.next = ln;
                ln.next = t;
            }
        }
        if (jw>0){
            he.val = jw;
        }else{
            he = he.next;
        }
        return he;
    }



}
