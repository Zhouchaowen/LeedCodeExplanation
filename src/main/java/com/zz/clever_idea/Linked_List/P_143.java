package com.zz.clever_idea.Linked_List;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/reorder-list/
 * 给定一个单链表 L：L0→L1→…→Ln-1→Ln ，
 * 将其重新排列后变为： L0→Ln→L1→Ln-1→L2→Ln-2→…
 *
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 *
 * 示例 1:
 * 给定链表 1->2->3->4, 重新排列为 1->4->2->3.
 *
 * 示例 2:
 * 给定链表 1->2->3->4->5, 重新排列为 1->5->2->4->3.
 *
 * 空间复杂度 O(1)?
 */
public class P_143 {
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }
    public void reorderList(ListNode head) {
        if (head == null) return;
        if (head.next == null)return;
        ListNode p = head;
        Stack<ListNode> st = new Stack<>();
        int sum = 0;
        while (p!=null){
            sum++;
            st.add(p);
            p = p.next;
        }
        p = head;
        int i = 0;
        while (p!=null){
            ListNode t = p.next;
            ListNode newNode = st.pop();
            if (newNode == t){ // 代表遍历到最后一位，赋值为null，不然会成环
                t.next = null;
                break;
            }
            p.next = newNode;
            newNode.next = t;
            p = t;
            i+=2;
            if(sum == i+1){// 代表遍历到最后一位
                p.next = null;
                break;
            }
        }
    }

    // 优雅写法
    public void reorderList2(ListNode head) {
        if (head == null) return;
        if (head.next == null)return;
        ListNode p = head;
        List<ListNode> list = new ArrayList<>();
        while(p!=null){
            list.add(p);
            p = p.next;
        }
        int i = 0,j = list.size()-1;
        for(;i<j;){
            list.get(i).next = list.get(j);
            i++;
            if (i == j){
                break;
            }
            list.get(j).next = list.get(i);
            j--;
        }
        list.get(i).next = null;
    }

    // O(1)
    public void reorderList3(ListNode head) {
        if (head == null) return;
        if (head.next == null)return;
        // 找到链表的中点 slow.next(必须要取next);
        ListNode p = head;
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        // 翻转后半段
        ListNode pre= null;
        ListNode cur = slow.next;
        slow.next = null;
        while (cur!=null){
           ListNode t = cur.next;
           cur.next = pre;
           pre = cur;
           cur = t;
        }
        // 合并前半段和后半段
        while(pre != null){
            ListNode t = pre.next;
            pre.next = head.next;
            head.next = pre;
            head = pre.next;
            pre = t;
        }
    }


}
