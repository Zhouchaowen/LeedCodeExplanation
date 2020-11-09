package com.zz.clever_idea.Linked_List;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/palindrome-linked-list/
 * 优化思路：快慢指针，链表翻转
 *
 * 编写一个函数，检查输入的链表是否是回文的。
 * 示例 1：
 * 输入： 1->2
 * 输出： false
 *
 * 示例 2：
 * 输入： 1->2->2->1
 * 输出： true
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

    // 暴力
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

    // 快慢指针

    /**
     *
     *   1   ->   2    ->    2   ->   1
     *  fast
     *  slow
     *   1   ->   2    ->    2   ->   1
     *           fast                slow
     *   1   ->   2    null    <-    2   <-   1
     *                                       pre   slow
     *   1   ->   2    null    <-    2   <-   1
     *  fast                                 pre
     *
     * @param head
     * @return
     */
    public boolean isPalindrome2(ListNode head) {
        if (head == null) return true;
        ListNode fast = head,slow = head;
        // 找出中间位置
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        // 过滤奇数情况
        if (fast != null) slow = slow.next;
        // 翻转后半段链表
        ListNode pre = null;
        while (slow != null){
            ListNode t = slow.next;
            slow.next = pre;
            pre = slow;
            slow = t;
        }
        // 一次对比
        fast = head;
        while (pre!=null){
            if (fast.val != pre.val)
                return false;
            pre = pre.next;
            fast = fast.next;
        }
        return true;
    }
}
